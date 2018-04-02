package cn.polysys.springboot.logindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hujie
 * @date 2018/03/29
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Spring Boot, Hello world!";
    }
}
