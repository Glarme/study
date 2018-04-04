package cn.polysys.springboot.logindemo.core;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 管理系统运行中Http,Session之类的操作，如用写入session的用户信息，后期的cookies等信息
 *
 * @author hujie
 * @date 2018/04/03
 */
@Component
public class SystemUtil {

    private final static String SESSION_USER = "currentUser";

    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpSession session;

    public HttpSession getSession() {
        return request.getSession();
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * 获取当前登录用户信息
     *
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getCurrentUser() {
        return (T) session.getAttribute(SESSION_USER);
    }

    /**
     * 设置的当前用户信息
     *
     * @param t
     * @param <T>
     */
    public <T> void setCurrentUser(T t) {
        session.setAttribute(SESSION_USER, t);
    }
}
