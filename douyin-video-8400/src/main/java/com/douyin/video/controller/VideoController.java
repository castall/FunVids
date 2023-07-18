package com.douyin.video.controller;

import com.douyin.common.entities.video.*;
import com.douyin.common.validators.DateTimeValidator;
import com.douyin.video.service.VideoService;
import com.douyin.video.utils.Minio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.douyin.common.utils.R;

import javax.validation.constraints.Min;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author castall
 * @date 2023/7/16 21:06
 */
@RestController
@RequestMapping("/douyin")
public class VideoController {

    @Autowired
    VideoService videoService;
    // 转换Video类型到Videos类型
    private VideoResp convertVideosToVideoResp(Videos videos){
        VideoResp videoResp = new VideoResp();
        videoResp.setId(videos.getId());
        videoResp.setPlay_url(videos.getPlayUrl());
        videoResp.setCover_url(videos.getCoverUrl());
        videoResp.setFavorite_count(videos.getFavoriteCount());
        videoResp.setComment_count(videos.getCommentCount());
        // 转换Integer到boolean
        Integer favoriteValue = videos.getIsFavorite();
        videoResp.set_favorite(favoriteValue!=null?favoriteValue!=0:false);
        videoResp.setTitle(videos.getTitle());

        return videoResp;
    }
    private List<VideoResp> convertVideosListToVideoRespList(List<Videos> videosList){
        List<VideoResp> videoRespList = videosList.stream()
                .map(this::convertVideosToVideoResp)
                .collect(Collectors.toList());
        return videoRespList;
    }
    // TODO 返回信息中添加User信息
    @GetMapping("/feed/")
    public VideoFeedResp getVideoFeed(@RequestBody VideoFeedReq videoFeedReq){

        // 返回对象
        VideoFeedResp videoFeedResp = new VideoFeedResp();
        // 获取此时间之前的视频
        LocalDateTime latestTime;
        // 时间格式转换
        long currentReqTime = videoFeedReq.getLatest_time();
        try{
             latestTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(currentReqTime), ZoneId.systemDefault());
             if(DateTimeValidator.isValidDateTime(latestTime) == false){
                 throw new Exception("invalid date time");
             }
        }catch (Exception e){
            videoFeedResp.setStatus_code(400);
            videoFeedResp.setStatus_msg("时间参数异常: " + e.toString());
            return videoFeedResp;
        }
        // 获取视频列表
        List<Videos> videosList = videoService.getVideoFeedByTime(latestTime);
        // 视频列表转换
        if(videosList!=null && videosList.size() != 0){
            videoFeedResp.setStatus_code(200);
            videoFeedResp.setStatus_msg("ok");
            List<VideoResp> videoRespList = convertVideosListToVideoRespList(videosList);
            videoFeedResp.setVideo_list(videoRespList);
        }
        else{
            videoFeedResp.setStatus_code(400);
            videoFeedResp.setStatus_msg("视频为空");
        }
        return videoFeedResp;
    }
    //
    @PostMapping("/publish/action/")
    public PublishVideoResp publishVideo(@RequestBody PublishVideoReq publishVideoReq){
        PublishVideoResp publishVideoResp = new PublishVideoResp();
        try{
            // Minio.publishVideo()
            publishVideoResp.setStatus_code(200);
            publishVideoResp.setStatus_msg("视频上传成功");
        }catch (Exception e){
            publishVideoResp.setStatus_code(400);
            publishVideoResp.setStatus_msg("视频上传失败");
        }
        return publishVideoResp;
    }
    // TODO 返回信息中添加User信息
    @PostMapping("/publish/list/")
    public PublishVideoListResp getPublishVideoList(@RequestBody PublishVideoListReq publishVideoListReq){
        PublishVideoListResp publishVideoListResp = new PublishVideoListResp();
        // 获取视频列表
        List<Videos> videosList = videoService.getVideoListByUserID(publishVideoListReq.getUser_id());
        // 视频列表转换
        if(videosList!=null && videosList.size() != 0){
            publishVideoListResp.setStatus_code(200);
            publishVideoListResp.setStatus_msg("ok");
            List<VideoResp> videoRespList = convertVideosListToVideoRespList(videosList);
            publishVideoListResp.setVideo_list(videoRespList);
        }
        return null;
    }
}
