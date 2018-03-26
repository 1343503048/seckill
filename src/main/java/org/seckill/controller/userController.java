package org.seckill.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class userController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        request.getSession().setAttribute("user_id", "1001");
        return "redirect:/seckill/list";
    }
}
