use seckill;

CREATE TABLE orders (
  order_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '订单ID',
  order_user_id BIGINT NOT NULL COMMENT '用户ID',
  order_goods_id BIGINT NOT NULL COMMENT '货物ID',
  order_create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  order_state TINYINT NOT NULL DEFAULT 0 COMMENT '0: 未支付, 1: 已支付,未发货, 2:已发货, 3:订单完成',
  FOREIGN KEY (order_goods_id) REFERENCES goods(goods_id),
  FOREIGN KEY (order_user_id) REFERENCES user(user_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT ='订单信息表';