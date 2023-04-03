package com.atguigu.controller;

import com.atguigu.controller.utils.R;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping   //默认是get请求
    public R getAll(){
        return new R(true,userService.list());
    }
    @PostMapping
    public R save(@RequestBody User user) throws IOException{   //异步提交发送，参数通过请求体传json数据过来
        //处理异常，抛到ProjectExceptionAdivce类进行处理 (如果等于123，就抛出异常)
        if (user.getName().equals("123")) throw new IOException();
        boolean flag=userService.save(user);
        return new R(flag,flag ? "添加成功！" : "添加失败。");
    }
    @PutMapping
    public R update(@RequestBody User user){
        return new R(userService.updateById(user));
    }
    //http://localhost/users/2
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(userService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,userService.getById(id));
    }

//分页
@GetMapping("{currentPage}/{pageSize}")
public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,User user){  //使用实体类进行接收页面的条件数据内容
    IPage<User> page=userService.getPage(currentPage,pageSize,user);
    if (currentPage>page.getPages()){
        page=userService.getPage((int)page.getPages(),pageSize,user);
    }
    return new R(true,page);
}
}
