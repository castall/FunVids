package com.douyin.common.entities.video;

import lombok.Data;

import java.util.List;

/**
 * @author castall
 * @date 2023/7/17 14:15
 */
@Data
public class PublishVideoListResp {
//    required int32 status_code = 1; // 状态码，0-成功，其他值-失败
//    optional string status_msg = 2; // 返回状态描述
//    repeated Video video_list = 3; // 用户发布的视频列表
    private int status_code;
    private String status_msg;
    private List<VideoResp> video_list;
}
