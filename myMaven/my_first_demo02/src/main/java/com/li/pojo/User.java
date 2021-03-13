package com.li.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable{
    private int uid; //用户id
    /**
    *姓名
    */
    private String username;
    /**
    *性别
    */
    private String sex;
    /**
    *birthday
    */
    private Date birthday;
    /**
    *address
    */
    private String address;


}
