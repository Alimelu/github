/**
 * @author pwxcoo
 * @package com.pwxcoo.github
 * @email pwxcoo@gmail.com
 * @date 2018/09/21
 * @time 23:36
 * @description
 */
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id`                INT NOT NULL auto_increment,
  `email`             VARCHAR(255) NOT NULL,
  `username`          VARCHAR(255) NOT NULL,
  `password`          VARCHAR(255) NOT NULL,
  `creation_time`     DATETIME NOT NULL DEFAULT current_timestamp,
  `modification_time` DATETIME NOT NULL DEFAULT current_timestamp on UPDATE current_timestamp,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`username`),
  UNIQUE KEY (`email`)
) engine = innodb;