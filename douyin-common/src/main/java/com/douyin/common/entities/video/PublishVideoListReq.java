package com.douyin.common.entities.video;

import lombok.Data;

/**
 * @author castall
 * @date 2023/7/17 14:15
 */
@Data
public class PublishVideoListReq {
    //    required int64 user_id = 1; // 用户id
    //    required string token = 2; // 用户鉴权token
    private String status_msg;
    private Integer user_id;
}
//    required int64 user_id = 1; // 用户id
//    required string token = 2; // 用户鉴权token
