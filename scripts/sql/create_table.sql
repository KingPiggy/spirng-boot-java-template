/**
    MySql 8.0 기준
    ENGINE : InnoDB
    DEFAULT CHAR SET : utf8mb4
    DEFAULT COLLATION : utf8mb4_0900_ai_ci
*/


-- create database
CREATE DATABASE kingpiggy_study;

CREATE TABLE `tb_hello` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ShedLock 테이블 자동 생성 안 될 경우 사용
CREATE TABLE `shedlock` (
    `name` VARCHAR(64) NOT NULL,
    `lock_until` TIMESTAMP(3) NOT NULL,
    `locked_at` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    `locked_by` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`name`)
);

CREATE TABLE `tb_code_group` (
    `code_group_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `code_group_nm` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`code_group_id`)
);

CREATE TABLE `tb_code` (
    `code_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `code_group_id` bigint(20) NOT NULL,
    `code_nm` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`code_id`)
);

CREATE TABLE `tb_sample_item` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `title` varchar(255) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    `code_id` bigint(20) DEFAULT NULL,
    `base_date` varchar(255) DEFAULT NULL,
    `amount` decimal(10, 2) DEFAULT NULL,
    `created_at` datetime(6) DEFAULT NULL,
    `created_by` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
