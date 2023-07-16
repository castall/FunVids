package com.douyin.common.entities.auth;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Gary
 * @create 2023-07-16 13:04
 */
@Data
public class AuthResp implements Serializable {
    //required int32 status_code = 1; // 状态码，0-成功，其他值-失败
    //  optional string status_msg = 2; // 返回状态描述
    //  required int64 user_id = 3; // 用户id
    //  required string token = 4; // 用户鉴权token

    private int status_code;
    private String status_msg;
    private Integer user_id;
    private String token;
}
