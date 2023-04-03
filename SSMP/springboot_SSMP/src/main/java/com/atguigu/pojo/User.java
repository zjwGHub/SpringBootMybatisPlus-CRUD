package com.atguigu.pojo;

import lombok.Data;

//lombok
@Data
public class User {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
