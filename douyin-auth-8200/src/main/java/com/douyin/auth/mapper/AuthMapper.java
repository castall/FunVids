package com.douyin.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.douyin.common.entities.user.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Gary
 * @create 2023-07-16 19:16
 */
@Mapper
public interface AuthMapper extends BaseMapper<Users> {


}
