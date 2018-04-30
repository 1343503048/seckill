package org.seckill.result;

public class CodeMsg {
  // 通用异常
  public static CodeMsg SUCCESS = new CodeMsg(0, "success");
  public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
  public static CodeMsg LOGIN_ERROR = new CodeMsg(500200, "用户名或者密码错误");
  // 秒杀模块 5005XX
  public static CodeMsg SECKILL_END = new CodeMsg(500500, "秒杀结束");
  // 登录模块 5002XX
  public static CodeMsg SECKILL_NOT_START = new CodeMsg(500501, "秒杀未开始");

  // 商品模块 5003XX

  // 订单模块 5004XX
  public static CodeMsg SECKILL_URL_ERROR = new CodeMsg(500502, "秒杀地址错误");
  public static CodeMsg SECKILL_REPEAT_KILL = new CodeMsg(500503, "重复秒杀");
  private int code;
  private String msg;

  private CodeMsg(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "CodeMsg{" + "code=" + code + ", msg='" + msg + '\'' + '}';
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
