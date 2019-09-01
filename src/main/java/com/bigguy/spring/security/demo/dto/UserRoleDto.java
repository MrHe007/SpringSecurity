package com.bigguy.spring.security.demo.dto;

import lombok.Data;

/**
 * @author bigguy_hc
 * @create 2019-09-01 11:39
 */
@Data
public class UserRoleDto {

    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色标识
     */
    private String resource;
}
