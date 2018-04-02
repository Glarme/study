create database springboot default charset utf8;
use springboot;
create table `user`(
id int primary key auto_increment,
username varchar(32) not null unique,
`password` varchar(32) not null
)
