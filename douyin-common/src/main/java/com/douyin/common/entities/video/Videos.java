package com.douyin.common.entities.video;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
* 
* @TableName videos
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("videos")
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

}
