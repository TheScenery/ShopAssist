CREATE TABLE t_user
(
    `id`           bigint(20) NOT NULL COMMENT 'Primary Key',
    `name`         varchar(50)  NOT NULL COMMENT 'Nick Name',
    `mobile_phone` varchar(50)           DEFAULT NULL COMMENT 'Mobile Phone',
    `email`        varchar(100) NOT NULL COMMENT 'Email',
    `password`     varchar(255) NOT NULL COMMENT 'Password',
    `avatar`       varchar(255)          DEFAULT NULL COMMENT 'Avatar',
    `is_deleted`   tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Delete Tag (1: Yes, 0: No)',
    `create_time`  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create Time',
    `update_time`  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update Time'
);