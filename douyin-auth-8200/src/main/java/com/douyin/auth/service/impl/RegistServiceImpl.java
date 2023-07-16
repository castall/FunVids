package com.douyin.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.douyin.auth.mapper.RegistMapper;
import com.douyin.auth.service.RegistService;
import com.douyin.auth.utils.JWT;
import com.douyin.auth.utils.PasswordEncoding;
import com.douyin.common.entities.auth.AuthReq;
import com.douyin.common.entities.auth.AuthResp;
import com.douyin.common.entities.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Gary
 * @create 2023-07-16 13:06
 */
@Service
public class RegistServiceImpl implements RegistService {
    @Autowired
    private RegistMapper registMapper;
    @Override
    public AuthResp regist(AuthReq authReq) {
        AuthResp authResp = new AuthResp();
        // 根据用户名查询注册用户名是否已存在
        String userName = authReq.getUsername();
        String password = PasswordEncoding.encoding(authReq.getPassword());
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Users> user_db = queryWrapper.eq("user_name", userName);
        if(user_db == null){ // 未查询到用户，可以注册
            Users users = new Users();
            users.setUserName(userName);
            users.setPassword(password);
            int insert = registMapper.insert(users);
            String token = JWT.generateToken("111",users.getId());
            authResp.setStatus_code(0);
            authResp.setToken(token);
            authResp.setUser_id(users.getId());
            authResp.setStatus_msg("regist success");
        }else{ // 查询到用户，不可以注册
            authResp.setStatus_code(1);
            authResp.setToken(null);
            authResp.setUser_id(null);
            authResp.setStatus_msg("user existed");
        }
        return authResp;
    }
}
