package cn.polysys.springboot.logindemo.dao;

import cn.polysys.springboot.logindemo.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author hujie
 * @date 2018/03/29
 */

public interface UserMapper {
    /**
     * 根据参数查找
     *
     * @param param
     * @return
     */
    List<User> listByParam(Map<String, Object> param);


    /**
     * 插入新用户
     *
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    int update(User user);


    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    User get(Integer id);

    /**
     * 查詢所有用戶
     *
     * @return
     */
    List<User> listAll();
}
