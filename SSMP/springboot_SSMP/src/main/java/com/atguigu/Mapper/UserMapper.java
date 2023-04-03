package com.atguigu.Mapper;

import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
//MP提供快速开发方案：继承BaseMapper<>,要一个泛型要操作哪个模块
public interface UserMapper extends BaseMapper<User> {

}
