package cn.polysys.springboot.logindemo.validate.impl;

import cn.polysys.springboot.logindemo.core.Message;
import cn.polysys.springboot.logindemo.validate.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author hujie
 * @date 2018/04/04
 */
@Component
public class UserValidator implements Validator {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserValidator.class);

    @Override
    public Message validate(Map<String, String[]> params) {
        String[] username = params.get("username");
        String[] password = params.get("password");
        if (username == null || password == null) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("用户信息验证失败");
            }
            return Message.failure("验证失败");
        }
        return Message.success();
    }
}
