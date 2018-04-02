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
     * @param params
     * @return
     */
    List<User> listByParams(Map<String,Object> params);

    /**
     * 查詢所有用戶
     * @return
     */
    List<User> listAll();
}
