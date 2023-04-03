package com.atguigu.service;

import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
public interface UserService extends IService<User> {
//    分页
IPage<User> getPage(int currentPage, int pageSize);

// 按条件查询
    IPage<User> getPage(int currentPage, int pageSize, User user);
}
