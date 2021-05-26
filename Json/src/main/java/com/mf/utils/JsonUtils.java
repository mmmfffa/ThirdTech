package com.mf.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.ct;

public class JsonUtils {
    //重载
    public static String getJson(Object object) throws JsonProcessingException {
        return getJson(object,"yyyy-MM-dd HH-mm-ss");
    }
    public static String getJson(Object object,String format) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //1.如何不返回时间戳,关闭
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
        //2.如何解决时间格式化问题
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        //3.指定mapper时间格式
        mapper.setDateFormat(dateFormat);

        return mapper.writeValueAsString(object);
    }
}
