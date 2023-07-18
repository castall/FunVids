package com.douyin.common.entities.video;

import lombok.Data;

/**
 * @author castall
 * @date 2023/7/17 14:14
 */
@Data
public class PublishVideoReq {
    private String token;
    private byte[] data;
    private String title;
    //    required string token = 1; // 用户鉴权token
    //    required bytes data = 2; // 视频数据
    //    required string title = 3; // 视频标题

}
