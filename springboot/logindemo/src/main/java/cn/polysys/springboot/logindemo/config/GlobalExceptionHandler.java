package cn.polysys.springboot.logindemo.config;

import cn.polysys.springboot.logindemo.validate.ValidateException;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 全局异常处理器
 *
 * @author hujie
 * @date 2018/04/02
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 数据校验异常处理,返回自定义的json格式信息
     *
     * @param ex
     * @param request
     * @param response
     * @throws IOException
     */
    @ExceptionHandler(value = ValidateException.class)
    private void handleValidate(ValidateException ex, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jsonString = JSON.toJSONString(ex.getMsg());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 捕获具体指定外的所有异常
     *
     * @param ex
     * @param request
     * @param response
     */
    @ExceptionHandler(value = Exception.class)
    private void handle(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("***** GlobalException Start *****");
        logger.error("Exception:{}", ex.toString());
        logger.error("Message：{}", ex.getMessage());
        logger.error("Request Url:{}", request.getRequestURL());
        Enumeration enumeration = request.getParameterNames();
        logger.error("Parameters:");
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement().toString();
            logger.error("[{}]:[{}]", name, request.getParameter(name));
        }
        StackTraceElement[] error = ex.getStackTrace();
        for (StackTraceElement stackTraceElement : error) {
            logger.error("StackTrace:{}", stackTraceElement.toString());
        }
        logger.error("***** GlobalException End *****");
    }


}
