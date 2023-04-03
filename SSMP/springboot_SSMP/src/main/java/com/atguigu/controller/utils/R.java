package com.atguigu.controller.utils;

import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object data;  //里面可能有集合等等
    //处理统一格式异常
    private String msg;
    public R(){}
    public R(Boolean flag){
        this.flag=flag;
    }
    public R(Boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }
    public R(Boolean flag,String msg){
        this.flag=flag;
        this.msg=msg;
    }
    //处理异常统一格式返回给前端
    public R(String msg){
        this.flag=false;
        this.msg=msg;
    }
}
