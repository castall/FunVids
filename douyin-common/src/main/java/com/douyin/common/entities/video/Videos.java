package com.douyin.common.entities.video;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 
* @TableName videos
*/
public class Videos implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Long id;
    /**
    * 
    */
    @ApiModelProperty("")
    private Date createdAt;
    /**
    * 
    */
    @ApiModelProperty("")
    private Date updatedAt;
    /**
    * 
    */
    @ApiModelProperty("")
    private Date deletedAt;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long authorId;
    /**
    * 
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("")
    @Length(max= -1,message="编码长度不能超过-1")
    private String playUrl;
    /**
    * 
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("")
    @Length(max= -1,message="编码长度不能超过-1")
    private String coverUrl;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long favoriteCount;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long commentCount;
    /**
    * 
    */
    @ApiModelProperty("")
    private Integer isFavorite;
    /**
    * 
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("")
    @Length(max= -1,message="编码长度不能超过-1")
    private String title;

    /**
    * 
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 
    */
    private void setCreatedAt(Date createdAt){
    this.createdAt = createdAt;
    }

    /**
    * 
    */
    private void setUpdatedAt(Date updatedAt){
    this.updatedAt = updatedAt;
    }

    /**
    * 
    */
    private void setDeletedAt(Date deletedAt){
    this.deletedAt = deletedAt;
    }

    /**
    * 
    */
    private void setAuthorId(Long authorId){
    this.authorId = authorId;
    }

    /**
    * 
    */
    private void setPlayUrl(String playUrl){
    this.playUrl = playUrl;
    }

    /**
    * 
    */
    private void setCoverUrl(String coverUrl){
    this.coverUrl = coverUrl;
    }

    /**
    * 
    */
    private void setFavoriteCount(Long favoriteCount){
    this.favoriteCount = favoriteCount;
    }

    /**
    * 
    */
    private void setCommentCount(Long commentCount){
    this.commentCount = commentCount;
    }

    /**
    * 
    */
    private void setIsFavorite(Integer isFavorite){
    this.isFavorite = isFavorite;
    }

    /**
    * 
    */
    private void setTitle(String title){
    this.title = title;
    }


    /**
    * 
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 
    */
    private Date getCreatedAt(){
    return this.createdAt;
    }

    /**
    * 
    */
    private Date getUpdatedAt(){
    return this.updatedAt;
    }

    /**
    * 
    */
    private Date getDeletedAt(){
    return this.deletedAt;
    }

    /**
    * 
    */
    private Long getAuthorId(){
    return this.authorId;
    }

    /**
    * 
    */
    private String getPlayUrl(){
    return this.playUrl;
    }

    /**
    * 
    */
    private String getCoverUrl(){
    return this.coverUrl;
    }

    /**
    * 
    */
    private Long getFavoriteCount(){
    return this.favoriteCount;
    }

    /**
    * 
    */
    private Long getCommentCount(){
    return this.commentCount;
    }

    /**
    * 
    */
    private Integer getIsFavorite(){
    return this.isFavorite;
    }

    /**
    * 
    */
    private String getTitle(){
    return this.title;
    }

}
