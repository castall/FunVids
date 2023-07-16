package com.douyin.auth.service.impl;

import com.douyin.auth.service.AuthService;
import com.douyin.auth.utils.JWT;
import com.douyin.common.constant.RedisPrefix;
import com.douyin.common.entities.auth.AuthDTO;
import com.douyin.common.entities.auth.AuthReq;
import com.douyin.common.entities.auth.AuthResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Gary
 * @create 2023-07-16 11:48
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public AuthDTO auth(AuthDTO authDTO) {
        String token = authDTO.getToken();
        String userId =redisTemplate.opsForValue().get(token);
        if(userId == null){ // redis中没有，说明过期了或者不存在
            authDTO.setFlag(false);
            return authDTO;
        }else { // redis有，说明校验成功
            authDTO.setFlag(true);
            // 自动延期
            redisTemplate.boundValueOps(token).set(userId,RedisPrefix.USER_TOKEN_EXPIRED_TIME, TimeUnit.SECONDS);
            return authDTO;
        }
    }
}
