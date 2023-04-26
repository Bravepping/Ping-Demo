package com.example.demo01.service;

import com.example.demo01.dao.CkUserDao;
import com.example.demo01.dao.UserDao;
import com.example.demo01.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CkUserService {
    @Autowired
    private CkUserDao ckUserDao;

    public void insertUser(String ckbh, String kssj, String jssj){
        ckUserDao.insertCkXx(ckbh, kssj,jssj);
    }
}
