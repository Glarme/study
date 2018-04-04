package cn.polysys.springboot.logindemo.service.impl;

import cn.polysys.springboot.logindemo.dao.UserMapper;
import cn.polysys.springboot.logindemo.model.User;
import cn.polysys.springboot.logindemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hujie
 * @date 2018/03/29
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 登陆验证
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        Map<String, Object> param = new HashMap<>(4);
        param.put("username", username);
        param.put("password", password);
        List<User> users = userMapper.listByParam(param);
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User get(Integer id) {
        return userMapper.get(id);
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        return userMapper.update(user);
    }


    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }
}
