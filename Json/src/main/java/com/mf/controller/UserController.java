package com.mf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mf.pojo.User;
import com.mf.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/json1")
    //RequestMapping正常返回会走视图解析器，而json只需要返回json字符串而已
    //使用三方工具：Jackson，fastjson
    //@ResponseBody将服务器返回的对象转换为json对象返回
    @ResponseBody
    public String json1() throws JsonProcessingException {
        //需要Jackson的对象映射器，将对象转换成字符串
        ObjectMapper mapper = new ObjectMapper();
        //创建对象
        User user = new User("上官婉儿", 1, "女");
        System.out.println(user);
        //将对象转为字符串
        String json = mapper.writeValueAsString(user);
        System.out.println(json);
        return  json;//不会转到视图解析器
    }
    //如果有前端输出有乱码问题
    @RequestMapping(value = "/json2",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(new User("上官婉儿", 1, "女"));
    }

    @RequestMapping(value = "/json3")
    @ResponseBody
    public String json3() throws JsonProcessingException {
        List<User> list = new ArrayList<>();
        list.add(new User("上官婉儿1", 1, "女"));
        list.add(new User("上官婉儿2", 2, "女"));
        list.add(new User("上官婉儿3", 3, "女"));
        list.add(new User("上官婉儿4", 4, "女"));

        return new ObjectMapper().writeValueAsString(list);
    }

    @RequestMapping(value = "/time")
    @ResponseBody
    public String json4() throws JsonProcessingException {
        Date date = new Date();
        System.out.println(date);
        return new ObjectMapper().writeValueAsString(date);
    }
    @RequestMapping(value = "/time2")
    @ResponseBody
    public String json5() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //1.如何不返回时间戳,关闭
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
        //2.如何解决时间格式化问题
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        //3.指定mapper时间格式
        mapper.setDateFormat(dateFormat);
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return mapper.writeValueAsString(date);
    }

    @RequestMapping(value = "/time3")
    @ResponseBody
    public String json6() throws JsonProcessingException {
        return JsonUtils.getJson(new Date());
    }

    @RequestMapping(value = "/json7")
    @ResponseBody
    public String json7() throws JsonProcessingException {
        List<User> list = new ArrayList<User>();
        list.add(new User("上官婉儿1", 1, "女"));
        list.add(new User("上官婉儿2", 2, "女"));
        list.add(new User("上官婉儿3", 3, "女"));
        list.add(new User("上官婉儿4", 4, "女"));

        return JsonUtils.getJson(list);
    }

}
