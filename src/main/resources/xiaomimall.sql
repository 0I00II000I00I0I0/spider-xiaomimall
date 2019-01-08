USE `spider_xiaomi`;
CREATE TABLE `xiaomimall` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` VARCHAR(20) DEFAULT NULL COMMENT '产品ID',
  `product_url` VARCHAR(100) DEFAULT NULL COMMENT '产品链接',
  `name_edition` VARCHAR(100) DEFAULT NULL COMMENT '商品名称',
  `price_min` VARCHAR(20) DEFAULT NULL COMMENT '商品价格',
  `price_max` VARCHAR(20) DEFAULT NULL COMMENT '商品原价',
  `comment_number` VARCHAR(100) DEFAULT NULL COMMENT '评论数',
  `comment` VARCHAR(100) DEFAULT NULL COMMENT '评论详情',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息表';