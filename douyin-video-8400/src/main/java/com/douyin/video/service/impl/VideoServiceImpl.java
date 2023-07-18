package com.douyin.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.douyin.common.entities.video.Videos;
import com.douyin.video.mapper.VideoMapper;
import com.douyin.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.time.LocalDateTime;

/**
 * @author castall
 * @date 2023/7/17 17:22
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Videos> getVideoFeedByTime(LocalDateTime latestTime) {
        // 查询当前时间以前的视频
        QueryWrapper<Videos> queryWrapper = Wrappers.<Videos>query().lt("created_at",latestTime);
        return videoMapper.selectList(queryWrapper);
    }

    @Override
    public List<Videos> getVideoListByUserID(Integer userId) {
        QueryWrapper<Videos> queryWrapper = Wrappers.<Videos>query().eq("user_id",userId);
        return videoMapper.selectList(queryWrapper);
    }

    @Override
    public void insertVideoInfo(Videos videos) {
        videoMapper.insert(videos);
    }
}
