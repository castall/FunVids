package com.douyin.common.entities.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Gary
 * @create 2023-07-16 21:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthDTO implements Serializable {
    private Boolean flag;
    private String token;
}
