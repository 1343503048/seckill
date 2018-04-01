package org.seckill.controller;

import org.seckill.result.CodeMsg;
import org.seckill.result.Result;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("username", 2333);
        return "login";
    }

    @RequestMapping(value = "/do_login",
            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Result doLogin(HttpSession session,
                        @RequestParam(value = "phone", required = false) Long phone,
                        @RequestParam(value = "password", required = false) String password) {
        if (password == null) return Result.error(CodeMsg.SERVER_ERROR);
        System.out.println("login");
        System.out.println("phone: " + phone);
        System.out.println("password: " + password);
        if (userService.login(phone, password)) {
            session.setAttribute("user_id", phone.toString());
            System.out.println(session.getAttribute("user_id"));
            System.out.println("login-session-id: " + session.getId());
            System.out.println("登录成功");
            return Result.success("登录成功");
        }
        System.out.println("登录失败");
        return Result.error(CodeMsg.LOGIN_ERROR);
    }
}
