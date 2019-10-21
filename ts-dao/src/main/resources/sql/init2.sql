-- auto-generated definition
create table ts_test2
(
    id          int auto_increment
        primary key,
    test_name   varchar(32)                         null,
    test_age    int                                 null,
    create_time timestamp default CURRENT_TIMESTAMP null,
    update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

