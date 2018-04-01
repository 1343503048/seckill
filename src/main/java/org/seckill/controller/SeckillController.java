package org.seckill.controller;

import com.sun.org.apache.bcel.internal.classfile.Code;
import org.seckill.entity.Goods;
import org.seckill.result.CodeMsg;
import org.seckill.result.Result;
import org.seckill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private GoodsService goodsService;

    private String slat = "dashiwiw92wq929";

    @RequestMapping(value = "/time/now", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Result<Long> now() {
        long now = System.currentTimeMillis()/1000;
        System.out.println("now: " + now);
        return Result.success(now);
    }

    @RequestMapping(value = "/{id}/seckillurl", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Result<String> getSeckillUrl(HttpServletRequest request, @PathVariable("id") long id) {
        System.out.println(request.getRequestURI());
        Goods goods = goodsService.getGoodsById(id);

        long nowTime = System.currentTimeMillis();
        long startTime = goods.getGoodsSeckillStartTime().getTime();
        long endTime = goods.getGoodsSeckillEndTime().getTime();

        if(nowTime < startTime) {
            return Result.error(CodeMsg.SECKILL_NOT_START);
        }
        else if(nowTime > endTime) {
            return Result.error(CodeMsg.SECKILL_END);
        }
        else {
            String url = DigestUtils.md5DigestAsHex((id + slat).getBytes());
            System.out.println(Result.success(url));
            return Result.success(url);
        }
    }

    @RequestMapping(value = "/{id}/{md5}/execution", method = RequestMethod.POST)
    @ResponseBody
    public Result execKill(HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        return null;
    }
}
