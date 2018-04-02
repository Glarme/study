package cn.polysys.springboot.logindemo.util;

import cn.polysys.springboot.logindemo.config.WebAppConfiguration;
import cn.polysys.springboot.logindemo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hujie
 * @date 2018/03/29
 */

public class AuthHandlerInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(AuthHandlerInterceptor.class);

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

        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.hasMethodAnnotation(Auth.class)) {
                //如果對Auth註解額外添加信息，則可以如此獲取註解信息
                // Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
                User user = (User) request.getSession().getAttribute(WebAppConfiguration.SESSION_USER);
                if (user != null) {
                    logger.info("auth success,username:{},success path:{}", user.getUsername(), request.getRequestURI());
                    return true;
                } else {
                    response.getWriter().write("auth failure,please goto login");
                    logger.info("auth failure");
                    return false;
                }
            } else {
                logger.info("pass url {}", request.getRequestURI());
                return true;
            }
        } else {
            logger.info("pass url {}", request.getRequestURI());
            return true;
        }
    }
}
