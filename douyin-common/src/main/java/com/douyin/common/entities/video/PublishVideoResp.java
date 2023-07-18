package com.douyin.common.entities.video;

import lombok.Data;

/**
 * @author castall
 * @date 2023/7/17 14:14
 */
@Data
public class PublishVideoResp {
    private int status_code;
    private String status_msg;
    //    required int32 status_code = 1; // 状态码，0-成功，其他值-失败
    //    optional string status_msg = 2; // 返回状态描述
}
