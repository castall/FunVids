package com.douyin.auth.controller;

import com.douyin.auth.service.RegistService;
import com.douyin.common.entities.auth.AuthReq;
import com.douyin.common.entities.auth.AuthResp;
import com.douyin.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gary
 * @create 2023-07-16 11:44
 */
@RestController
public class RegistController {

    @Autowired
    RegistService registService;

    @PostMapping("/douyin/user/register")
    public R regist(@RequestBody AuthReq authReq){
        AuthResp authResp = registService.regist(authReq);
        return R.ok().setData(authResp);
    }

}
