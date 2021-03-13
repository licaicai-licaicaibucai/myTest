package com.li.dao;

import com.li.pojo.QueryBean;
import com.li.pojo.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有的用户
     * @return
     */
    public List<User> findAll();

    /**
     * 通过id删除用户
     * @param id
     */
    public void deleteById(int id);

    /**
     * 添加新用户
     * @param user
     */
    public void addUser(User user);

    /**
     * 添加用户并且返回用户id
     * @param user
     * @return
     */
    public int  addUserAndReturnId(User user);

    /**
     * 通过名字进行查询
     * @param name
     * @return
     */
    List<User> searchByUsername(String name);

    /**
     * 复杂函数查询
     * @param queryBean
     * @return
     */
    List<User> findByQueryBean(QueryBean queryBean);


}
