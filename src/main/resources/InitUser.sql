CREATE DATABASE AdapterTest;
use AdapterTest;
DROP TABLE IF EXISTS User;
CREATE TABLE User (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      password VARCHAR(100) NOT NULL ,
                      email VARCHAR(100) NOT NULL UNIQUE
);
