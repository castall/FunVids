package com.douyin.auth.service;

import com.douyin.common.entities.auth.AuthDTO;
import com.douyin.common.entities.auth.AuthReq;
import com.douyin.common.entities.auth.AuthResp;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

/**
 * @author Gary
 * @create 2023-07-16 11:48
 */

public interface AuthService {
    AuthDTO auth(AuthDTO userId);
}
