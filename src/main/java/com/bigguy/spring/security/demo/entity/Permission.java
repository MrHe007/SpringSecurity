package com.bigguy.spring.security.demo.entity;

import lombok.Data;

/**
 * @author bigguy_hc
 * @create 2019-09-01 11:36
 */
@Data
public class Permission {

    private Integer id;

    /**
     * 权限描述
     */
    private String name;

    /**
     * 权限操作标识
     */
    private String resource;
}
