use seckill;

CREATE TABLE user (
  user_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
  user_name VARCHAR(30) NOT NULL COMMENT '名字',
  user_phone BIGINT NOT NULL COMMENT '电话',
  user_password VARCHAR(10) NOT NULL COMMENT '登录密码'
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT ='用户信息表';

ALTER TABLE user ADD UNIQUE KEY (user_phone);

INSERT INTO user (user_name, user_phone, user_password) VALUES
  ('Horstmann', 132225650001, 123456),
  ('Josiah', 132225650002, 123456),
  ('Carson', 132225650003, 123456),
  ('David', 132225650004, 123456)