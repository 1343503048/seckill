package org.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seckill")
public class ListController {

    @RequestMapping("/list")
    public String list() {
        return "list";
    }

    public static void main(String[] args) {
        System.out.print("hello world");
    }
}
