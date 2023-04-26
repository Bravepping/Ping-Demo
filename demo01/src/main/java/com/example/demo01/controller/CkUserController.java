package com.example.demo01.controller;

import com.example.demo01.dao.CkUserDao;
import com.example.demo01.dao.UserDao;
import com.example.demo01.pojo.CkUser;

import com.example.demo01.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;


@Controller
public class CkUserController {
    @Autowired
    private CkUserDao ckUserDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping("/start_jh")
    @ResponseBody
    public String insertCkXx(HttpSession session){
        CkUser ckuser = (CkUser) session.getAttribute("ckuser");
        String bh = userDao.findBh();
        if (ckuser !=null){
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//format:获取当前时间
            System.out.println(ckuser.getStatus());
            if (ckuser.getStatus() == 'Y')
                return "请先完成结束当前业务！";
            else {
                if (bh == null || bh.equals("")) return "取号端中已无顾客编号";
                else{
                    ckUserDao.insertCkXx(ckuser.getCkbh(),format,"");
                    ckuser.setStatus('Y');
                    session.setAttribute("ckuser",ckuser);
                    userDao.findStatusByBh(0,bh);
                    ckUserDao.ckUserStatus('Y',ckuser.getUsername());
                    System.out.println("请编号"+bh+"前往"+ckuser.getCkbh()+"窗口办理业务");
                    return "操作成功==========>"+"请编号"+bh+"前往"+ckuser.getCkbh()+"窗口办理业务";
                }
            }
        }
        else
            return "未登录-账号信息异常";
    }

    @ResponseBody
    @RequestMapping("/end_jh")
    public String endCkXx(HttpSession session){
        CkUser ckuser = (CkUser) session.getAttribute("ckuser");
        if (ckuser != null){

            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//format:获取当前时间
            if (ckuser.getStatus() =='Y'){
                System.out.println("结束业务");
                ckUserDao.endCkXx(format,1,ckuser.getCkbh());

                ckuser.setStatus('N');
                session.setAttribute("ckuser",ckuser);

                ckUserDao.ckUserStatus('N',ckuser.getUsername());
                return "业务办理结束，请评价！";

            }
            else return "没有已完成或正在办理的业务！";
        }
        else
            return "未登录-账号信息异常";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@PathParam("username") String username,@PathParam("password") String password, HttpSession session){
        CkUser ckUser = ckUserDao.loginCkUser(username, password);
        if (ckUser!=null){
            session.setAttribute("ckuser",ckUser);
            System.out.println(ckUser);
            return "登录成功";
        }
        else
            return "账号或密码错误";
    }
    @ResponseBody
    @RequestMapping("/getckuserxm")
    public String getCkUserXm(HttpSession session){
        CkUser ckuser = (CkUser) session.getAttribute("ckuser");
        if (ckuser == null || ckuser.equals("")){
            return "请先登录系统";
        }else return "欢迎你："+ckuser.getCkbh();
    }


    @RequestMapping("show")
    public String findByStatus0(Model model){
        LinkedList<User> byStatus0 = userDao.findByStatus(0);
        LinkedList<User> byStatus = userDao.findByStatus(-1);
        model.addAttribute("status0",byStatus0);
        model.addAttribute("status",byStatus);
        return "show";
    }
    @ResponseBody
    @RequestMapping("show1")
    public LinkedList<User> showInfo1(){
        LinkedList<User> byStatus0 = userDao.findByStatus(0);
        LinkedList<User> byStatus = userDao.findByStatus(-1);
        return byStatus0;
    }
}
