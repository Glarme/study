package cn.polysys.springboot.logindemo.config;

import cn.polysys.springboot.logindemo.core.auth.AuthHandlerInterceptor;
import cn.polysys.springboot.logindemo.validate.ValidatorHandlerInterceptor;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(WebAppConfiguration.class);

    /**
     * 权限校验拦截器
     *
     * @return
     */
    @Bean
    public AuthHandlerInterceptor getAuthHandlerInterceptor() {
        return new AuthHandlerInterceptor();
    }

    /**
     * 数据校验拦截器
     *
     * @return
     */
    @Bean
    public ValidatorHandlerInterceptor getValidatorHandlerInterceptor() {
        return new ValidatorHandlerInterceptor();
    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 添加权限过滤拦截器
        registry.addInterceptor(getAuthHandlerInterceptor()).addPathPatterns("/**");
        // 添加数据校验拦截器
        registry.addInterceptor(getValidatorHandlerInterceptor()).addPathPatterns("/**");
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("add Interceptors");
        }

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("add resource handler");
        }
    }

}
