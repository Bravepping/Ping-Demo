package com.example.demo01.dao;

import com.example.demo01.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.LinkedList;

@Mapper
public interface UserDao {
    void insertUser(User user);
    String findBh();
    Integer findPaiDui();
    String getIndexBh();
    @Select("select * from demo1user ORDER BY bh")
    LinkedList<User> findAll();
    @Update("update demo1user set status=#{status} where bh=#{bh}")
    void findStatusByBh(Integer status,String bh);
    @Select("select * from demo1user where status=#{status}")
    LinkedList<User> findByStatus(Integer status);
}
