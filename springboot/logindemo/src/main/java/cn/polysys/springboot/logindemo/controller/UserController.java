package cn.polysys.springboot.logindemo.controller;

import cn.polysys.springboot.logindemo.core.Message;
import cn.polysys.springboot.logindemo.core.auth.Auth;
import cn.polysys.springboot.logindemo.model.User;
import cn.polysys.springboot.logindemo.service.UserService;
import cn.polysys.springboot.logindemo.validate.BeforeValidate;
import cn.polysys.springboot.logindemo.validate.impl.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author hujie
 * @date 2018/03/29
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 列出所有用户
     *
     * @param model
     * @return
     */
    @Auth
    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("users", userService.listAll());
        return "user/list";
    }

    /**
     * 显示添加用户页面
     *
     * @return
     */
    @Auth
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String toAddPage() {
        return "user/add";
    }

    @Auth
    @BeforeValidate(UserValidator.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Message add(User user) {
        int count = userService.insert(user);
        if (count > 0) {
            return Message.success("insert success");
        }
        return Message.failure("insert failure");
    }

    @Auth
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String toUpdatePage(Integer uid, Model model) {
        User user = userService.get(uid);
        model.addAttribute("user", user);
        return "user/update";
    }

    @Auth
    @BeforeValidate(UserValidator.class)
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Message update(User user) {
        int count = userService.update(user);
        if (count > 0) {
            return Message.success("update success");
        }
        return Message.failure("update failure");
    }

}
