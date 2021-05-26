package com.mf.controller;

import com.mf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
    //第一种方式：服务器返回一个字符串，直接使用response
    @RequestMapping("/a1")
    public void ajax01(String name, HttpServletResponse resp) throws IOException {
       if("admin".equals(name)) resp.getWriter().write("true");
       else resp.getWriter().write("false");
    }

    @RequestMapping("/a2")
    @ResponseBody
    public List<User> ajax02(){
        List<User> list = new ArrayList<User>();
        list.add(new User("上官婉儿1", 1, "女"));
        list.add(new User("上官婉儿2", 2, "女"));
        list.add(new User("上官婉儿3", 3, "女"));
        list.add(new User("上官婉儿4", 4, "女"));
        return list;
    }

    @RequestMapping("/a3")
    @ResponseBody
    public String ajax03(String name, String pwd) {
          String msg="";
          if (name!=null){
              if ("admin".equals(name)) msg="ok";
              else msg="error";
          }
        if (pwd!=null){
            if ("123".equals(pwd)) msg="ok";
            else msg="error";
        }
        return msg;
    }
}
