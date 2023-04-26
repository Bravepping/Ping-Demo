package com.example.demo01.controller;

import com.alibaba.excel.EasyExcel;
import com.example.demo01.pojo.User;
import com.example.demo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    int index =1;

    @ResponseBody
    @RequestMapping("/one")
    public String insertUser(User user, @PathParam("xm") String xm,@PathParam("sfz") String sfz,@PathParam("phone") String phone){
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//format:获取当前时间
        String indexBh = userService.getIndexBh();
        if (indexBh != null){
            String pattern = "[1-9]+.*";
            Pattern pattern1 = Pattern.compile(pattern);
            Matcher matcher = pattern1.matcher(indexBh);
//        while (matcher.find()){
//            System.out.println(matcher.group());
//        }
            if (matcher.find()){
                String group = matcher.group();

                index = Integer.parseInt(group);
                index++;
                System.out.println(index);
            }
        }
        String uid = UUID.randomUUID().toString();
        String uuid = uid.replaceAll("-", "");
        user.setUuid(uuid);
        if (index<10){
            user.setBh("A00"+index);
        }
        if (index<100&&index>=10){
            user.setBh("A0"+index);
        }
        if (index>=100){
            user.setBh("A"+index);
        }
        user.setXm(xm);
        user.setSfz(sfz);
        user.setPhone(phone);
        user.setCjsj(format);
        user.setKssj("");
        user.setJssj("");
        user.setCkbh("");
        user.setStatus(-1);
        System.out.println(user);
        userService.insertUser(user);
        Integer paiDui = userService.findPaiDui();
        index++;
        return "尊敬的"+user.getXm()+"你好\n取号成功=====>你的编号为"+user.getBh()+"\n前方排队还有"+--paiDui+"人======>请耐心等待";
    }


    @RequestMapping("/admin")
    public String findAll(Model model){
        model.addAttribute("userinfo",userService.findAll());
        return "superadmin";
    }

    /**
     * 普通导出方式
     */
    @RequestMapping("/export")
    public void exportMembers1(HttpServletResponse response) throws IOException {
        // 设置文本内省
        response.setContentType("application/vnd.ms-excel");
        // 设置字符编码
        response.setCharacterEncoding("utf-8");
        // 设置响应头
        response.setHeader("Content-disposition", "attachment;filename=demo.xlsx");
        EasyExcel.write(response.getOutputStream(), User.class).sheet("模板").doWrite(userService.findAll());
    }

}
