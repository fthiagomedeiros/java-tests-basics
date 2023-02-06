### 1. Create database structure

```mysql
CREATE DATABASE CUSTOMER_INFO;
USE CUSTOMER_INFO;

create table customer (
    id varchar(255) not null, 
    first_name varchar(255), 
    last_name varchar(255), 
    username varchar(255), 
    primary key (id)
);


INSERT INTO CUSTOMER_INFO.CUSTOMER VALUES ('2', 'FRANCISCO', 'MEDEIROS', 'fthiagomedeiros');
INSERT INTO CUSTOMER_INFO.CUSTOMER VALUES ('3', 'ASSIS', 'MEDEIROS', 'assismedeiros');
INSERT INTO CUSTOMER_INFO.CUSTOMER VALUES ('4', 'ALEXANDRE', 'MEDEIROS', 'alexmedeiros');
```

```mysql
drop table if exists customer
drop table if exists customer_seq
create table customer (id bigint not null, first_name varchar(255), last_name varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table customer_seq (next_val bigint) engine=InnoDB

INSERT INTO customer` (`id`, `first_name`, `last_name`, `username`) VALUES ('2', 'Alexandre', 'Medeiros', 'alexandremedeiros');

```