package org.seckill.controller;

import org.seckill.entity.Goods;
import org.seckill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring4.context.SpringWebContext;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    @Autowired
    ApplicationContext applicationContext;
    /*

     */

    private String listHtml;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
        if (listHtml!=null) return listHtml;
        List<Goods> goodsList = goodsService.getGoodsList(0, 4);
        model.addAttribute("goodsList", goodsList);
        SpringWebContext context = new SpringWebContext(request, response, request.getServletContext(),
                request.getLocale(), model.asMap(), applicationContext);
        listHtml = thymeleafViewResolver.getTemplateEngine().process("list", context);
        return listHtml;
    }

    @RequestMapping("/{id}/detail")
    public String detail(Model model, @PathVariable("id") Long id) {

        Goods goods = goodsService.getGoodsById(id);
        model.addAttribute("goods", goods);

//        long now = System.currentTimeMillis()/1000;
        long startTime = goods.getGoodsSeckillStartTime().getTime()/1000;
        long endTime = goods.getGoodsSeckillEndTime().getTime()/1000;

        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        return "detail";
    }
}
