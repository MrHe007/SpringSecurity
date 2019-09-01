/*
Copyright (C) 2011-$today.year. ShenZhen IBOXCHAIN Information Technology Co.,Ltd.

All right reserved.

This software is the confidential and proprietary
information of IBOXCHAIN Company of China.
("Confidential Information"). You shall not disclose
such Confidential Information and shall use it only
in accordance with the terms of the contract agreement
you entered into with IBOXCHAIN inc.

*/
package com.bigguy.spring.security.demo.dto.map;/**
 * @Author: hechen
 * @Date: 2019/8/31 13:40
 * @Description: ...
 */

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author hechen
 * @data 2019/8/31
 */
public class RequestDto extends HashMap<String, Object> implements Serializable {


    public String getStr(String key){
        Object obj = this.get(key);
        if (null != obj) {
            if (obj instanceof String) {
                return (String) obj;
            } else if (obj instanceof Integer) {
                Integer data = (Integer) obj;
                return String.valueOf(data);
            } else if (obj instanceof Long) {
                Long data = (Long) obj;
                return String.valueOf(data);
            } else {
                return (String) obj;
            }
        }
        return null;
    }

    public Long getLong(String key) {
        Object obj = this.get(key);
        if (null != obj) {
            if (obj instanceof String) {
                String data = (String) obj;
                return Long.valueOf(data);
            } else if (obj instanceof Integer) {
                Integer data = (Integer) obj;
                return Long.valueOf(data);
            } else if (obj instanceof Long) {
                return (Long) obj;
            } else {
                return (Long) obj;
            }
        }

        return null;
    }

}
