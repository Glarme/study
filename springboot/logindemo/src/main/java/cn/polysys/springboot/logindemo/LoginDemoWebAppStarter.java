package cn.polysys.springboot.logindemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hujie
 * @date 2018/03/29
 */
@MapperScan("cn.polysys.springboot.logindemo.dao")
@SpringBootApplication
public class LoginDemoWebAppStarter {
    public static void main(String[] args) {
        SpringApplication.run(LoginDemoWebAppStarter.class, args);
    }
}
