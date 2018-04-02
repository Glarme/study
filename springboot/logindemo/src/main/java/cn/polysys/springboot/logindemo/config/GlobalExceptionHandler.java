package cn.polysys.springboot.logindemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 全局异常处理器
 * @author hujie
 * @date 2018/04/02
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    private void handle(Exception ex, HttpServletRequest request, HttpServletResponse response){
        logger.error("***** GlobalException Start *****");
        logger.error("Exception:{}",ex.toString());
        logger.error("Message：{}" ,ex.getMessage());
        logger.error("Request Url:{}" , request.getRequestURL());
        Enumeration enumeration = request.getParameterNames();
        logger.error("Parameters:");
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement().toString();
            logger.error("[{}]:[{}]",name,request.getParameter(name));
        }
        StackTraceElement[] error = ex.getStackTrace();
        for (StackTraceElement stackTraceElement : error) {
            logger.error("StackTrace:{}",stackTraceElement.toString());
        }
        logger.error("***** GlobalException End *****");
    }
}
