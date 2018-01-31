create schema `itMag`;
DROP DATABASE IF EXISTS jwd_x;
CREATE DATABASE jwd_x DEFAULT CHARACTER SET utf8;

USE jwd_x;

GRANT ALL ON jwd_x.* TO 'jwd_x'@'%' IDENTIFIED BY 'jwd_x';

FLUSH PRIVILEGES;