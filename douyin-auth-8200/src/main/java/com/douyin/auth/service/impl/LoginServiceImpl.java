package com.douyin.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.douyin.auth.mapper.LoginMapper;
import com.douyin.auth.service.LoginService;
import com.douyin.auth.utils.JWT;
import com.douyin.auth.utils.PasswordEncoding;
import com.douyin.common.constant.RedisPrefix;
import com.douyin.common.entities.auth.AuthReq;
import com.douyin.common.entities.auth.AuthResp;

import com.douyin.common.entities.user.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Gary
 * @create 2023-07-16 13:20
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override // 登录接口
    public AuthResp login(AuthReq authReq) {
        AuthResp authResp = new AuthResp();
        // 构建查询条件
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        String username = authReq.getUsername();
        String password = PasswordEncoding.encoding(authReq.getPassword()); // 对明文密码进行加密
        queryWrapper.eq("user_name",username).eq("password",password);
        // 调用mapper执行条件查询
        Users user = loginMapper.selectOne(queryWrapper);
        if(user == null){ // 没有查询到此用户
            authResp.setStatus_code(1);
            authResp.setToken(null);
            authResp.setUser_id(null);
            authResp.setStatus_msg("user not found");
        }else{
            // 生成token并返回
            String token = JWT.generateToken("111", user.getId());
            authResp.setStatus_code(0);
            authResp.setToken(token);
            authResp.setUser_id(user.getId());
            authResp.setStatus_msg("success");
            //  并把当前用户的信息保存到redis中缓存(双写一致性问题)
            // key  为 token ； value 为 user:token:userId  ，过期时间为7天时间
            redisTemplate.opsForValue().set(token,RedisPrefix.USER_TOKEN + user.getId().toString(),
                    RedisPrefix.USER_TOKEN_EXPIRED_TIME, TimeUnit.SECONDS);
        }
        return authResp;
    }
}
