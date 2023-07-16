package com.douyin.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.douyin.common.entities.user.Users;
import org.apache.ibatis.annotations.Mapper;



/**
 * @author Gary
 * @create 2023-07-16 19:14
 */
@Mapper
public interface LoginMapper extends BaseMapper<Users> {
}
