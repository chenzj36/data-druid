package com.chenzj36.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/2/4 11:50
 * @Description
 */
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    @GetMapping("/insertUser")
    public String addUser(){
        String sql = "insert into mybatis.user(id,username,password) values('11','chen','123456')";
        jdbcTemplate.update(sql);
        return "insert OK";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUSer(@PathVariable("id") Integer id){
        String sql = "update mybatis.user set username=?, password=? where id="+id;
        Object[] objects = new Object[2];
        objects[0] = "陈";
        objects[1] = "258369";
        jdbcTemplate.update(sql, objects);
        return "updateUser OK";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        String sql = "delete from mybatis.user where id="+id;
        jdbcTemplate.update(sql);
        return "deleteUser OK";
    }

}
