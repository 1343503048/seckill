package org.seckill.entity;

import java.util.Date;

public class Goods {
    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsSeckillStartTime=" + goodsSeckillStartTime +
                ", goodsSeckillEndTime=" + goodsSeckillEndTime +
                ", goodsAddTime=" + goodsAddTime +
                ", goodsStock=" + goodsStock +
                ", goodsPrice=" + goodsPrice +
                '}';
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goosId) {
        this.goodsId = goosId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Date getGoodsSeckillStartTime() {
        return goodsSeckillStartTime;
    }

    public void setGoodsSeckillStartTime(Date goodsSeckillStartTime) {
        this.goodsSeckillStartTime = goodsSeckillStartTime;
    }

    public Date getGoodsSeckillEndTime() {
        return goodsSeckillEndTime;
    }

    public void setGoodsSeckillEndTime(Date goodsSeckillEndTime) {
        this.goodsSeckillEndTime = goodsSeckillEndTime;
    }

    public Date getGoodsAddTime() {
        return goodsAddTime;
    }

    public void setGoodsAddTime(Date goodsAddTime) {
        this.goodsAddTime = goodsAddTime;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    private long goodsId;
    private String goodsName;
    private Date goodsSeckillStartTime;
    private Date goodsSeckillEndTime;
    private Date goodsAddTime;
    private int goodsStock;
    private int goodsPrice;
}
