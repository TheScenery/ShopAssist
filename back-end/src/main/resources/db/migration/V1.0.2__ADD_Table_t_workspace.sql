CREATE TABLE t_workspace
(
    `id`           bigint(20) NOT NULL COMMENT 'Primary Key',
    `name`         varchar(50)  NOT NULL COMMENT 'Workspace Name',
    `owner_id`     bigint(20) NOT NULL COMMENT 'Owner ID',
    `is_deleted`   tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Delete Tag (1: Yes, 0: No)',
    `create_time`  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create Time',
    `update_time`  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update Time'
) comment 'table for workspaces';