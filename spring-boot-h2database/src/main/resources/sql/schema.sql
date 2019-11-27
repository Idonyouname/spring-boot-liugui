DROP TABLE IF EXISTS SYS_USER;
CREATE TABLE IF NOT EXISTS SYS_USER(
  `user_id` INT(20) NOT NULL COMMENT'用户ID',
  `user_name` VARCHAR(30) COMMENT '用户名',
  `user_sex` CHAR(1) COMMENT '性别',
  `user_age` CHAR(3) COMMENT'年龄',
  `user_phone` CHAR(11) COMMENT'手机号码',
  `user_email` VARCHAR(100) COMMENT'邮箱',
  `user_id_no` CHAR(18)  COMMENT'身份证号' ,
  `user_state` CHAR(1) COMMENT'用户状态',
  `create_time` DATE COMMENT'创建时间',
  `modify_time` DATE COMMENT'修改时间',
  `comment` VARCHAR(100) COMMENT'备注',
  PRIMARY KEY(user_id)
);
