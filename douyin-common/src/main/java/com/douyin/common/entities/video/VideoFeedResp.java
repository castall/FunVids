package com.douyin.common.entities.video;

import lombok.Data;

import java.util.List;

/**
 * @author castall
 * @date 2023/7/17 14:15
 */
@Data
public class VideoFeedResp {
    private int status_code;
    private String status_msg;
    private List<VideoResp> video_list;
    private long next_time;
}

