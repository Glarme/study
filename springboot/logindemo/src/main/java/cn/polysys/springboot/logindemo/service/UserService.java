package cn.polysys.springboot.logindemo.service;

import cn.polysys.springboot.logindemo.model.User;

import java.util.List;

/**
 * @author hujie
 * @date 2018/03/29
 */
public interface UserService {
    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 查看所有用户
     * @return
     */
    List<User> listAll();
}
