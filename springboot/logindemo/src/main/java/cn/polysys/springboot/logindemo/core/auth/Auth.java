package cn.polysys.springboot.logindemo.core.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.*;

/**
 * @author hujie
 * @date 2018/03/29
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.METHOD})
public @interface Auth {
    /**
     * 可用来配置额外信息，然后在{@link AuthHandlerInterceptor#preHandle(HttpServletRequest, HttpServletResponse, Object)}方法中获取处理
     *
     * @return
     */
    String value() default "";
}
