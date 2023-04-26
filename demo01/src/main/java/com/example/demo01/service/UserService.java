package com.example.demo01.service;

import com.example.demo01.dao.UserDao;
import com.example.demo01.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void insertUser(User user){
        userDao.insertUser(user);
    }
    public void loginCkUser(){

    }

    public Integer findPaiDui(){
        return userDao.findPaiDui();
    }

    public String getIndexBh(){
        return userDao.getIndexBh();
    }

    public LinkedList<User> findAll(){
        return userDao.findAll();
    }
    public void findStatusByBh(Integer status,String bh){
        userDao.findStatusByBh(status, bh);
    }
    LinkedList<User> findByStatus(Integer status){
        return userDao.findByStatus(status);
    }
}
