package org.seckill.controller;

import org.seckill.result.CodeMsg;
import org.seckill.result.Result;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(Model model) {
        ResourcePatternResolver
        model.addAttribute("username", 2333);
        return "login";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/do_login",
            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Result doLogin(HttpSession session,
                        @RequestParam(value = "phone", required = false) Long phone,
                        @RequestParam(value = "password", required = false) String password) {
        if (password == null) return Result.error(CodeMsg.SERVER_ERROR);
        long userId = userService.login(phone, password);
        if (userId != -1) {
            session.setAttribute("user_id", (Long)userId);
            return Result.success("登录成功");
        }
        System.out.println("登录失败");
        return Result.error(CodeMsg.LOGIN_ERROR);
    }
}
