package com.douyin.common.entities.user;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
* 
* @TableName t_users
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("t_users")
public class Users implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer id;
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
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("")
    @Length(max= -1,message="编码长度不能超过-1")
    private String userName;
    /**
    * 
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("")
    @Length(max= -1,message="编码长度不能超过-1")
    private String password;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long followCount;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long followerCount;
    /**
    * 
    */
    @ApiModelProperty("")
    private Integer isFollow;
    /**
    * 
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("")
    @Length(max= -1,message="编码长度不能超过-1")
    private String avatar;
    /**
    * 
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("")
    @Length(max= -1,message="编码长度不能超过-1")
    private String backgroundImage;
    /**
    * 
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("")
    @Length(max= -1,message="编码长度不能超过-1")
    private String signature;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long totalFavorited;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long workCount;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long favoriteCount;






}
