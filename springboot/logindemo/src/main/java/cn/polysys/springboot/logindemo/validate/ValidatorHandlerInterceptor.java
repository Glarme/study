package cn.polysys.springboot.logindemo.validate;

import cn.polysys.springboot.logindemo.core.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author hujie
 * @date 2018/04/04
 */
public class ValidatorHandlerInterceptor extends HandlerInterceptorAdapter {

    private final static Logger LOGGER = LoggerFactory.getLogger(ValidatorHandlerInterceptor.class);

    @Resource
    private Map<String, Validator> validatorMap;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (!handlerMethod.hasMethodAnnotation(BeforeValidate.class)) {
            return true;
        }

        BeforeValidate beforeValidate = handlerMethod.getMethodAnnotation(BeforeValidate.class);
        Class<? extends Validator>[] classes = beforeValidate.value();
        for (Class clz : classes) {
            Validator validator = getValidator(clz);
            Message message = validator.validate(request.getParameterMap());
            if (!message.isSuccess()) {
                LOGGER.info("校验失败:{}", message.getMsg());
                throw new ValidateException(message);
            }
        }
        return true;
    }

    private Validator getValidator(Class clz) {
        String simpleName = clz.getSimpleName();
        String name = Character.toLowerCase(simpleName.charAt(0)) +
                simpleName.substring(1);
        return validatorMap.get(name);
    }
}