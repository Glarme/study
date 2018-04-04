package cn.polysys.springboot.logindemo.core.auth;

import cn.polysys.springboot.logindemo.core.SystemUtil;
import cn.polysys.springboot.logindemo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hujie
 * @date 2018/03/29
 */

public class AuthHandlerInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthHandlerInterceptor.class);

    @Resource
    private SystemUtil systemUtil;

    /**
     * 校验请求是否是添加Auth注解，有注解则做权限验证
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            LOGGER.info("pass url {}", request.getRequestURI());
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (!handlerMethod.hasMethodAnnotation(Auth.class)) {
            LOGGER.info("pass url {}", request.getRequestURI());
            return true;
        }

        User user = systemUtil.getCurrentUser();

        if (user != null) {
            LOGGER.info("auth success,username:{},success path:{}", user.getUsername(), request.getRequestURI());
            return true;
        }
        response.getWriter().write("auth failure,please goto login");
        LOGGER.info("auth failure");
        return false;

    }
}
