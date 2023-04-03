package com.atguigu.controller.utils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为springmvc的异常处理器
//数据层和业务层最终也会抛到表现层去的，所以在controller层处理就行
@RestControllerAdvice   //定义是controller异常处理器
public class ProjectExceptionAdvice {
//    拦截所有异常信息
    @ExceptionHandler
    public R doException(Exception ex){
        //记录日记(异常)   通知运维    通知开发
        ex.printStackTrace();  //显示控制台异常信息
        return new R("服务器故障，请稍后再试！");   //返回值为R，这样运行出来的异常信息进行统一格式
    }
}
