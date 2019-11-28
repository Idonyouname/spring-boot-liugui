DROP TABLE IF EXISTS SYS_USER;
CREATE TABLE IF NOT EXISTS SYS_USER(
  `user_id` INT(20) NOT NULL COMMENT'用户ID',
  `user_name` VARCHAR(30) COMMENT '用户名',
  `user_sex` CHAR(1) COMMENT '性别',
  `user_age` CHAR(3) COMMENT'年龄',
  PRIMARY KEY(user_id)
);
