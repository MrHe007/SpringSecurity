package com.bigguy.spring.security.demo.entity;

import lombok.Data;

/**
 * @author bigguy_hc
 * @create 2019-09-01 11:34
 */
@Data
public class Role {

    private Integer id;
    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色标识
     */
    private String sn;
}
