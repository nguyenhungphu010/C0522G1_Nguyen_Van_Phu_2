drop database if exists module_6_sprint_2; 
create database module_6_sprint_2; 
use module_6_sprint_2;

CREATE TABLE IF NOT EXISTS book_types (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    image TEXT,
    supplier VARCHAR(100),
    author VARCHAR(100),
    translator VARCHAR(100),
    publisher VARCHAR(100),
    publish_year INT,
    weight INT,
    demension VARCHAR(100),
    pages INT,
    cover VARCHAR(50),
    price DOUBLE,
    stock MEDIUMINT,
    details TEXT,
    book_type INT,
    FOREIGN KEY (book_type)
        REFERENCES book_types (id),
    is_delete BIT DEFAULT 0
);
CREATE TABLE IF NOT EXISTS user (
    username VARCHAR(30) PRIMARY KEY,
    password VARCHAR(200),
    is_delete BIT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS role (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    is_delete BIT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS user_role (
    username VARCHAR(50),
    role_id INT,
    is_delete BIT DEFAULT 0,
    FOREIGN KEY (username)
        REFERENCES user (username),
    FOREIGN KEY (role_id)
        REFERENCES role (id),
    PRIMARY KEY (username , role_id)
);

CREATE TABLE IF NOT EXISTS customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    phone_number VARCHAR(15),
    day_of_birth VARCHAR(30),
    email VARCHAR(100),
    gender INT,
    address VARCHAR(200),
    username VARCHAR(30) UNIQUE,
    is_delete BIT DEFAULT 0,
    FOREIGN KEY (username)
        REFERENCES user (username)
);
CREATE TABLE IF NOT EXISTS shipping (
    id INT PRIMARY KEY AUTO_INCREMENT,
    method VARCHAR(100),
    price DOUBLE
);
CREATE TABLE IF NOT EXISTS orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    shipping_id INT,
    payment_method VARCHAR(100),
    date_process VARCHAR(50),
     `status` BIT default(0),
    is_delete BIT DEFAULT 0,
    FOREIGN KEY (customer_id)
        REFERENCES customers (id),
    FOREIGN KEY (shipping_id)
        REFERENCES shipping (id)
);
CREATE TABLE IF NOT EXISTS order_detail (
    order_id INT,
    book_id INT,
    quantity SMALLINT,
    FOREIGN KEY (book_id)
        REFERENCES books (id),
    FOREIGN KEY (order_id)
        REFERENCES orders (id),
    PRIMARY KEY (order_id , book_id)
);




 
