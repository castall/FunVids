package com.douyin.common.entities.video;

import lombok.Data;

/**
 * @author castall
 * @date 2023/7/17 14:15
 */
@Data
public class VideoFeedReq {
    private long latest_time;
    private String token;
}
//        optional int64 latest_time = 1; // 可选参数，限制返回视频的最新投稿时间戳，精确到秒，不填表示当前时间
//        optional string token = 2； // 可选参数，登录用户设置