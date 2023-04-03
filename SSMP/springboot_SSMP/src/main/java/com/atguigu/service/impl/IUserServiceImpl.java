package com.atguigu.service.impl;

import com.atguigu.Mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// 泛型1:要用的实现类   泛型2：对应的实体类
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    //分页
    @Override
    public IPage<User> getPage(int currentPage, int pageSize) {
        IPage page=new Page(currentPage,pageSize);
        userMapper.selectPage(page,null);
        return page;
    }
    //按条件查询
    @Override
    public IPage<User> getPage(int currentPage,int pageSize, User user) {
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<User>();
        //条件匹配(动态条件)
        lqw.like(Strings.isNotEmpty(user.getType()),User::getType,user.getType());  //如果不是空，就执行操作
        lqw.like(Strings.isNotEmpty(user.getName()),User::getName,user.getName());
        lqw.like(Strings.isNotEmpty(user.getDescription()),User::getDescription,user.getDescription());
        IPage page=new Page(currentPage,pageSize);
        userMapper.selectPage(page,lqw);
        return page;
    }
}












