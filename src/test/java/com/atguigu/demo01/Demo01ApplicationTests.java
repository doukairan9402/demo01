package com.atguigu.demo01;

import com.atguigu.demo01.entity.User;
import com.atguigu.demo01.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class Demo01ApplicationTests {
    /*required = flase在没有对应bean 的时候也不会报错*/
    @Autowired(required=false)
    private UserMapper userMapper;

    @Test
    void findAll() {
        List<User> allUser  =  userMapper.selectList(null);
        System.out.println(allUser);
    }
    @Test
    void addUser(){
        User newUser= new User();
        newUser.setAge(15);
        newUser.setEmail("771317300@qq.com");
        newUser.setMname("addUser1");
        System.out.println(userMapper.insert(newUser));
    }
    @Test
    void updataUser(){
        User newUser= new User();
        newUser.setAge(151);
        newUser.setId(2L);
        System.out.println(userMapper.updateById(newUser));

    }



    @Test
    void autoAddUser(){
        User newUser= new User();
        newUser.setAge(151);
        newUser.setMname("auto1");
        newUser.setEmail("202105111410@qq.com");
        System.out.println(userMapper.insert(newUser));

    }

    @Test
    void autoUpUser(){
        //查询
//        User yUser = userMapper.selectById(1392042740091551745L);
//        yUser.setAge(12);
        //批量查询
//
//        String[] a2 = {"11","12","13", "14", "15"};
//        List<String > a3 = Arrays.asList(a2);
//        String[] a4 = a3.toArray(new String[]{});
        List<User> listUser = userMapper.selectBatchIds(Arrays.asList(1,3));
        for(User yId:listUser){
            userMapper.updateById(yId);
        }
    }

    @Test
    void paging(){
        Page<User> userList = new Page<>(1,2);
        Page<User> users = userMapper.selectPage(userList,null);
        System.out.println(users.orders());

    }

}
