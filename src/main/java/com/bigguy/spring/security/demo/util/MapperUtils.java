/*
 * Copyright (C) 2011-2015 ShenZhen iBOXPAY Information Technology Co.,Ltd.
 * 
 * All right reserved.
 * 
 * This software is the confidential and proprietary
 * information of iBoxPay Company of China. 
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement 
 * you entered into with iBoxpay inc.
 *
 *
 */
package com.bigguy.spring.security.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * json及object帮助类
 *
 *
 * @author: wangyanhui
 * @since: 2015/03/21
 *
 */
public class MapperUtils {

    /**
     * convert object to json value, not include null value.
     * @param source
     * @param destination
     */
    public static String toJson(Object obj) {
        return toJson(obj, true, null);
    }

    /**
     * convert object to json value, whether exclude null value as "null".
     * @param source
     * @param destination
     */
    public static String toJson(Object obj, boolean excludeNull, SerializeFilter filter) {
        if (obj == null) {
            return "";
        }

        //排除为空，将不打印空值
        if (excludeNull) {
            if (filter != null) {
                return JSONObject.toJSONString(obj, filter, SerializerFeature.IgnoreNonFieldGetter, SerializerFeature.SortField);
            } else {
                return JSONObject.toJSONString(obj, SerializerFeature.IgnoreNonFieldGetter, SerializerFeature.SortField);
            }
        } else {
            if (filter != null) {
                return JSONObject.toJSONString(obj, filter, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.IgnoreNonFieldGetter, SerializerFeature.SortField);
            } else {
                return JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.IgnoreNonFieldGetter, SerializerFeature.SortField);
            }
        }
    }

    public static String toJson(Object object, SerializeFilter filter) {
        return toJson(object, true, filter);
    }

    /**
     * convert object from json value
     * @param source
     * @param destination
     */
    public static <T> T map(String jsonString, Class<T> clazz) {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }

        return JSON.parseObject(jsonString, clazz);
    }

    /**
     * convert list object from json value
     * @param source
     * @param destination
     */
    public static <T> List<T> mapToList(String jsonString, Class<T> clazz) {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }

        return JSONArray.parseArray(jsonString, clazz);
    }

    /**
     * convert list object from json value
     * @param source
     * @param destination
     */
    public static <T> Map<String, T> toMap(String jsonString) {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }

        return JSON.parseObject(jsonString, new TypeReference<Map<String, T>>() {});
    }
    
    
    /**
     * convert bean object to map
     * @param source
     * @param destination
     */
    public static <T> Map<String, T> beanToMap(Object object) {
        if ( object == null) {
            return null;
        }
        
        String jsonString = toJson(object);
        return toMap(jsonString);
    }
    
    /**
     * 过滤json打印
     * @param object
     * @param filters
     * @param features
     * @return
     */
    public static final String toJSONString(Object object, SerializeFilter[] filters, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter();

        try {
            JSONSerializer serializer = new JSONSerializer(out);
            for (com.alibaba.fastjson.serializer.SerializerFeature feature : features) {
                serializer.config(feature, true);
            }
            serializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            if (filters != null) {
                for (SerializeFilter filter : filters) {

                    if (filter instanceof PropertyPreFilter) {
                        serializer.getPropertyPreFilters().add((PropertyPreFilter) filter);
                    }

                    if (filter instanceof NameFilter) {
                        serializer.getNameFilters().add((NameFilter) filter);
                    }

                    if (filter instanceof ValueFilter) {
                        serializer.getValueFilters().add((ValueFilter) filter);
                    }

                    if (filter instanceof PropertyFilter) {
                        serializer.getPropertyFilters().add((PropertyFilter) filter);
                    }

                    if (filter instanceof BeforeFilter) {
                        serializer.getBeforeFilters().add((BeforeFilter) filter);
                    }

                }
            }
            serializer.write(object);
            return out.toString();
        } finally {
            out.close();
        }
    }
}
