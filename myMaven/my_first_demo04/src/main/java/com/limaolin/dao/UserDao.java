package com.limaolin.dao;

import com.limaolin.pojo.User;

public interface UserDao {
    User findAll();
    int updateUser();
}
