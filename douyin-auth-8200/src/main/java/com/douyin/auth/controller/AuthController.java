package com.douyin.auth.controller;

import com.douyin.auth.service.AuthService;
import com.douyin.common.entities.auth.AuthDTO;
import com.douyin.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gary
 * @create 2023-07-16 11:44
 */
@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/auth")
    public R auth(@RequestBody AuthDTO authDTO){
        AuthDTO auth = authService.auth(authDTO);
        return R.ok().setData(auth);
    }


}
