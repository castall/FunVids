package com.douyin.auth.service;

import com.douyin.common.entities.auth.AuthReq;
import com.douyin.common.entities.auth.AuthResp;

/**
 * @author Gary
 * @create 2023-07-16 13:06
 */
public interface RegistService {
    AuthResp regist(AuthReq authReq);
}
