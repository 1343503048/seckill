package org.seckill.controller;

import org.seckill.entity.Goods;
import org.seckill.entity.Order;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.result.CodeMsg;
import org.seckill.result.Result;
import org.seckill.service.GoodsService;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

  @Autowired private GoodsService goodsService;

  @Autowired private SeckillService seckillService;

  private String slat = "dashiwiw92wq929";

  @RequestMapping(
    value = "/time/now",
    method = RequestMethod.GET,
    produces = {"application/json;charset=utf-8"}
  )
  @ResponseBody
  public Result<Long> now() {
    long now = System.currentTimeMillis() / 1000;
    System.out.println("now: " + now);
    return Result.success(now);
  }

  @RequestMapping(
    value = "/{id}/seckillurl",
    method = RequestMethod.GET,
    produces = {"application/json;charset=utf-8"}
  )
  @ResponseBody
  public Result<String> getSeckillUrl(HttpServletRequest request, @PathVariable("id") long id) {
    System.out.println(request.getRequestURI());
    Goods goods = goodsService.getGoodsById(id);

    long nowTime = System.currentTimeMillis();
    long startTime = goods.getGoodsSeckillStartTime().getTime();
    long endTime = goods.getGoodsSeckillEndTime().getTime();

    if (nowTime < startTime) {
      return Result.error(CodeMsg.SECKILL_NOT_START);
    } else if (nowTime > endTime) {
      return Result.error(CodeMsg.SECKILL_END);
    } else {
      String url = DigestUtils.md5DigestAsHex((id + slat).getBytes());
      System.out.println(Result.success(url));
      return Result.success(url);
    }
  }

  @RequestMapping(value = "/{id}/{md5}/execution", method = RequestMethod.POST)
  @ResponseBody
  public Result execKill(
      HttpServletRequest request,
      @PathVariable("id") long goodsId,
      @PathVariable("md5") String md5) {
    System.out.println(request.getRequestURI());
    Goods goods = goodsService.getGoodsById(goodsId);
    long nowTime = System.currentTimeMillis();
    long startTime = goods.getGoodsSeckillStartTime().getTime();
    long endTime = goods.getGoodsSeckillEndTime().getTime();
    if (nowTime < startTime) {
      System.out.println(CodeMsg.SECKILL_NOT_START);
      return Result.error(CodeMsg.SECKILL_NOT_START);
    } else if (nowTime > endTime) {
      System.out.println(CodeMsg.SECKILL_END);
      return Result.error(CodeMsg.SECKILL_END);
    }
    String url = DigestUtils.md5DigestAsHex((goodsId + slat).getBytes());
    if (!url.equals(md5)) {
      System.out.println(CodeMsg.SECKILL_URL_ERROR);
      return Result.error(CodeMsg.SECKILL_URL_ERROR);
    }
    Long userPhone = (Long) request.getSession().getAttribute("user_id");
    System.out.println("user: " + userPhone);
    try {
      Order order = seckillService.doSeckill(userPhone, goodsId);
      return Result.success(order.getOrderId());
    } catch (RepeatKillException e) {
      e.printStackTrace();
      System.out.println(CodeMsg.SECKILL_REPEAT_KILL);
      return Result.error(CodeMsg.SECKILL_REPEAT_KILL);
    } catch (SeckillCloseException e) {
      e.printStackTrace();
      System.out.println(CodeMsg.SECKILL_END);
      return Result.error(CodeMsg.SECKILL_END);
    }
  }
}
