package cn.polysys.springboot.logindemo.controller;

import cn.polysys.springboot.logindemo.model.User;
import cn.polysys.springboot.logindemo.service.UserService;
import cn.polysys.springboot.logindemo.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author hujie
 * @date 2018/03/29
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(@RequestParam(name = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", true);
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password) {
        User user = userService.login(username, password);
        return user == null ? "redirect:login?error=true" : "redirect:list";
    }

    @Auth
    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("users", userService.listAll());
        return "user/list";
    }
}
