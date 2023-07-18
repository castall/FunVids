package com.douyin.common.entities.video;

import com.douyin.common.entities.user.Users;
import lombok.Data;

/**
 * @author castall
 * @date 2023/7/17 20:30
 */
@Data
public class VideoResp {
    private long id;
    private Users author;
    private String play_url;
    private String cover_url;
    private long favorite_count;
    private long comment_count;
    private boolean is_favorite;
    private String title;
}
