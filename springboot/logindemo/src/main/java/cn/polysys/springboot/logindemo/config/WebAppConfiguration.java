package cn.polysys.springboot.logindemo.config;

import cn.polysys.springboot.logindemo.util.AuthHandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author hujie
 * @date 2018/03/29
 */
@Configuration
@ComponentScan(basePackages = "cn.polysys.springboot.logindemo", useDefaultFilters = false, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})
})
public class WebAppConfiguration extends WebMvcConfigurationSupport {

    private Logger logger = LoggerFactory.getLogger(WebAppConfiguration.class);
    public final static String SESSION_USER = "user";

    @Bean
    public AuthHandlerInterceptor getAuthHandlerInterceptor() {
        return new AuthHandlerInterceptor();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
        logger.debug("add Interceptors");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        logger.debug("add resource handler");
    }

}
