### 1. Create database structure

1. Firstly, run a docker image for MySQL database.
```shell
docker run --name mysql105 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=12345678 -d mysql:latest
```

2. Create the following database structure

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

INSERT INTO `CUSTOMER_INFO`.`customer` (`id`, `first_name`, `last_name`, `username`) VALUES (1, 'Francisco', 'Medeiros', 'fthiagomedeiros');
INSERT INTO `CUSTOMER_INFO`.`customer` (`id`, `first_name`, `last_name`, `username`) VALUES (2, 'Assis', 'Medeiros', 'assismedeiros');
```