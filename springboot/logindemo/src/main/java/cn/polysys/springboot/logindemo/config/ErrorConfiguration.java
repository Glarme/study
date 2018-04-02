package cn.polysys.springboot.logindemo.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author hujie
 * @date 2018/04/02
 */
@Component
public class ErrorConfiguration implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage[] errorPages = new ErrorPage[]{
                new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"),
                new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"),
                new ErrorPage(java.lang.Throwable.class, "/error/500")
        };
        registry.addErrorPages(errorPages);
    }
}
