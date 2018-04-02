package cn.polysys.springboot.logindemo.service.impl;

import cn.polysys.springboot.logindemo.dao.UserMapper;
import cn.polysys.springboot.logindemo.model.User;
import cn.polysys.springboot.logindemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author hujie
 * @date 2018/03/29
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        Map<String,Object> params = new HashMap<String, Object>(4);
        params.put("username",username);
        params.put("password",password);
        List<User> users = userMapper.listByParams(params);
        if(!users.isEmpty()){
            return users.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }
}
