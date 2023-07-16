package com.douyin.auth.controller;

import com.douyin.auth.service.LoginService;
import com.douyin.common.entities.auth.AuthReq;
import com.douyin.common.entities.auth.AuthResp;
import com.douyin.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gary
 * @create 2023-07-16 11:43
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/douyin/user/login")
    public R login(@RequestBody AuthReq authReq){
        AuthResp login = loginService.login(authReq);
        return R.ok().setData(login);
    }

}
