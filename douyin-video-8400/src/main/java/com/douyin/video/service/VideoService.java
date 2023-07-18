package com.douyin.video.service;

import com.douyin.common.entities.video.Videos;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author castall
 * @date 2023/7/16 21:18
 */
public interface VideoService {

    List<Videos> getVideoFeedByTime(LocalDateTime latestTime);

    List<Videos> getVideoListByUserID(Integer userId);

    void insertVideoInfo(Videos videos);
}
