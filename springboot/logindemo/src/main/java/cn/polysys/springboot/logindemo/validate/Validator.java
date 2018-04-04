package cn.polysys.springboot.logindemo.validate;

import cn.polysys.springboot.logindemo.core.Message;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author hujie
 * @date 2018/04/04
 */
public interface Validator {
    /**
     * 校验方法，需要自己实现具体方法，参数是从{@link HttpServletRequest#getParameterMap()}获取的
     *
     * @param params
     * @return
     */
    Message validate(Map<String, String[]> params);
}
