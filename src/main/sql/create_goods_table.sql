use seckill;

SELECT * from goods;

CREATE TABLE goods (
  goods_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '货物ID',
  goods_name VARCHAR(200) NOT NULL COMMENT '名字',
  goods_seckill_start_time TIMESTAMP NOT NULL COMMENT '秒杀开始时间',
  goods_seckill_end_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀结束时间',
  goods_add_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品添加时间',
  goods_price INT NOT NULL COMMENT '商品价格',
  goods_stock INT NOT NULL COMMENT '商品库存'
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT ='商品信息表';

INSERT INTO goods(goods_name, goods_stock, goods_price, goods_seckill_start_time, goods_seckill_end_time)
VALUES   ('Apple MacBook Pro 13.3英寸笔记本电脑 深空灰色（2017新款Core i5处理器/8GB内存/128GB硬盘 MPXQ2CH/A）', 50, 9288.00, '2018-03-27 19:00:00', '2018-03-27 21:00:00'),
  ('【宜昌扶贫馆】湖北秭归橙子 纽荷尔脐橙 新鲜水果 现摘现发 2.5斤', 50, 19.90, '2018-03-27 19:00:00', '2018-03-27 21:00:00'),
  ('华为（HUAWEI）荣耀畅玩平板2（四核 3G/32G 1280x800 4800mAh WiFi高配版 8英寸）苍穹灰', 50, 1028.00, '2018-03-27 19:00:00', '2018-03-27 21:00:00'),
  ('凤凰（Phoenix） 凤凰自行车山地车21/24/27速26寸', 50, 549.00, '2018-03-27 19:00:00', '2018-03-27 21:00:00')


