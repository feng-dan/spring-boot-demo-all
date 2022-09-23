CREATE TABLE `t_user`
(
    `id`       BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '用户编号',
    `username` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '账号',
    `password` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '密码',
    `age`      INT         NOT NULL DEFAULT '0' COMMENT '年龄'
);