package com.douyin.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.douyin.common.entities.video.Videos;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author castall
 * @date 2023/7/17 18:09
 */
@Mapper
public interface VideoMapper extends BaseMapper<Videos> {
}
