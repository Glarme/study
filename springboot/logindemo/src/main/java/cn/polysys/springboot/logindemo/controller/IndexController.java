package cn.polysys.springboot.logindemo.controller;

import cn.polysys.springboot.logindemo.core.SystemUtil;
import cn.polysys.springboot.logindemo.model.User;
import cn.polysys.springboot.logindemo.service.UserService;
import cn.polysys.springboot.logindemo.validate.BeforeValidate;
import cn.polysys.springboot.logindemo.validate.impl.UserValidator;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * 首页及登陆退出操作
 *
 * @author hujie
 * @date 2018/04/04
 */
@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @Resource
    private SystemUtil systemUtil;


    /**
     * 默认首页
     *
     * @return
     */
    @RequestMapping({"/", "index"})
    public String index() {
        return "index";
    }

    /**
     * 展示登陆页面，如果存在登陆错误，可错误错误代码返回错误信息
     *
     * @param errorCode
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLoginPage(@RequestParam(name = "error", required = false) String errorCode, Model model) {
        if (errorCode != null) {
            model.addAttribute("error", true);
            model.addAttribute("errorMsg", errorCode);
        }
        return "login";
    }

    /**
     * 处理登陆操作
     *
     * @param userForm
     * @return
     */
    @BeforeValidate(UserValidator.class)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User userForm) {
        User user = userService.login(userForm.getUsername(), userForm.getPassword());
        if (user != null) {
            systemUtil.setCurrentUser(user);
            return "redirect:index";
        }
        return "redirect:login?error=errorCode";
    }

    /**
     * 登出，注销
     *
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public ModelAndView logout() {

        systemUtil.getSession().invalidate();
        String requestMethod = systemUtil.getRequest().getMethod();
        boolean isGetMethod = HttpMethod.GET.matches(requestMethod.toUpperCase(Locale.ENGLISH));

        if (isGetMethod) {
            return new ModelAndView(new RedirectView("login"));
        }

        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        mv.addObject("success", true);
        return mv;
    }
}
