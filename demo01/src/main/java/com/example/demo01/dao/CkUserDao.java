package com.example.demo01.dao;

import com.example.demo01.pojo.CkUser;
import com.example.demo01.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CkUserDao {
    void insertCkXx(String ckbh, String kssj, String jssj);
    CkUser loginCkUser(String username, String password);
    void ckUserStatus(Character status,String username);

    void endCkXx(String jssj,Integer status, String ckbh);
}
