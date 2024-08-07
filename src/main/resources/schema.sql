drop table if exists products;
create table products (id identity primary key auto_increment,
                       created_on timestamp default now() not null,
                       modified_on timestamp default now() not null,
                       code varchar2 not null,
                       name varchar2 not null,
                       brand varchar2 not null,
                       color varchar2 not null);