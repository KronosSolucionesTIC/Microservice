CREATE DATABASE mydatabase;

USE mydatabase;

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `balance` double NOT NULL,
  `customer_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_number` varchar(255) DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `age` int NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `identification` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` bigint NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKr9okrktxscw3omxi1wm7cg18u` FOREIGN KEY (`id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `movement`;

CREATE TABLE `movement` (
  `amount` double NOT NULL,
  `available_balance` double NOT NULL,
  `date` date DEFAULT NULL,
  `initial_balance` double NOT NULL,
  `account_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `movement_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoemeananv9w9qnbcoccbl70a0` (`account_id`),
  CONSTRAINT `FKoemeananv9w9qnbcoccbl70a0` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;