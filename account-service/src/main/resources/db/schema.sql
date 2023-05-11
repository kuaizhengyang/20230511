create table t_account (
    id int(10) unsigned not null auto_increment comment '主键ID',
    user_id varchar(32) not null default '' comment '客户号',
    name varchar(255) not null default '' comment '客户名称',
    create_time datetime not null default '1970-01-01 00:00:00' comment '创建时间',
    create_by varchar(64) not null default '' comment '创建人',
    update_time timestamp null default current_timestamp on update current_timestamp comment '修改时间',
    update_by varchar(64) not null default comment '修改时间'
    primary key (id),
    key 'idx_t_account_user_id' (user_id)
);

create table sys_log
(
    id int(10) unsigned not null auto_increment comment '主键ID',
    branch_id     bigint       not null,
    xid           varchar(100) not null,
    context       varchar(128) not null,
    rollback_info longblob     not null,
    log_status    int          not null,
    log_created   datetime     not null,
    log_modified  datetime     not null,
    constraint ux_undo_log
        unique (xid, branch_id)
)
    charset = utf8mb3;

