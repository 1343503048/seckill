package org.seckill.entity;

import java.util.Date;

public class Order {
  private long orderId;

  private long orderUserId;

  private long orderGoodsId;

  private Date orderCreateTime;

  private int orderState;
  private String goodsName;
  private String userName;
  private long userPhone;

  public Order() {}

  @Override
  public String toString() {
    return "Order{"
        + "orderId="
        + orderId
        + ", orderUserId="
        + orderUserId
        + ", orderGoodsId="
        + orderGoodsId
        + ", orderCreateTime="
        + orderCreateTime
        + ", orderState="
        + orderState
        + ", goodsName='"
        + goodsName
        + '\''
        + ", userName='"
        + userName
        + '\''
        + ", userPhone="
        + userPhone
        + '}';
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public long getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(long userPhone) {
    this.userPhone = userPhone;
  }

  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  public long getOrderUserId() {
    return orderUserId;
  }

  public void setOrderUserId(long orderUserId) {
    this.orderUserId = orderUserId;
  }

  public long getOrderGoodsId() {
    return orderGoodsId;
  }

  public void setOrderGoodsId(long orderGoodsId) {
    this.orderGoodsId = orderGoodsId;
  }

  public Date getOrderCreateTime() {
    return orderCreateTime;
  }

  public void setOrderCreateTime(Date orderCreateTime) {
    this.orderCreateTime = orderCreateTime;
  }

  public int getOrderState() {
    return orderState;
  }

  public void setOrderState(int orderState) {
    this.orderState = orderState;
  }
}
