package com.atguigu.Mapper;

import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTestCase {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testGetByid(){
        System.out.println(userMapper.selectById(1));
    }
//    插入数据
    @Test
    void testSave(){
        User user=new User();
        user.setName("xm");
//        user.setAge("12");
//        user.setGender("男");
//        user.setEmail("123@qq.com");
        userMapper.insert(user);

    }

    @Test
    void testUpdate(){
        User user=new User();
        user.setId(3);
        user.setName("xm");
//        user.setAge("13");
//        user.setGender("女");
//        user.setEmail("123@qq.com");
        userMapper.insert(user);
    }

    @Test
    void testDelete(){
        userMapper.deleteById(7);
    }

    @Test
    void testGetAll(){
        System.out.println(userMapper.selectList(null));;
    }

    //分页查询
    @Test
    void testGetPage(){
        IPage page=new Page(1,5);   //哪一页数据，一页显示多少数据
        userMapper.selectPage(page,null);
        System.out.println(page.getCurrent());  // 当前页 例如，现在显示的1
        System.out.println(page.getSize());     // 一页显示的数据
        System.out.println(page.getTotal());    // 显示有多少条数据信息 也就是数据总和
        System.out.println(page.getPages());    // 计算一共多少页
        System.out.println(page.getRecords());  // 显示数据
    }

//按条件查询
    @Test
    void testGetBy(){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        //条件,所有包含xm名称的有哪些
        String name="6";
        //if (name!=null) lambdaQueryWrapper.like(User::getName,name);
        lambdaQueryWrapper.like(name!=null,User::getName,name);  //true连  false：不连
        userMapper.selectList(lambdaQueryWrapper);
    }
}
