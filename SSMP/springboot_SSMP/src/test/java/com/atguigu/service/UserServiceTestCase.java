package com.atguigu.service;

import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTestCase {
    @Autowired
    private UserService userService;
//    根据id查询
    @Test
    void testGetById(){
        System.out.println(userService.getById(2));
    }
//    插入
//    @Test
//    void testSave(){
//        User user=new User();
//        user.setName("xm");
//        user.setAge("12");
//        user.setGender("男");
//        user.setEmail("123@qq.com");
//        userService.save(user);
//    }
//    @Test
//    void testUpdate(){
//        User user=new User();
//        user.setId(3);
//        user.setName("xm");
//        user.setAge("13");
//        user.setGender("女");
//        user.setEmail("123@qq.com");
//        userService.updateById(user);
//    }
    @Test
    void testDelete(){
        userService.removeById(3);
    }
    @Test
    void testGetAll(){
        userService.list();
    }
    @Test
    void testGetPage(){
        IPage<User> page=new Page<User>(2,5);
        IPage<User> page1 = userService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
