CREATE DATABASE if NOT exists hexa;
USE hexa;
CREATE TABLE if NOT exists plant (
    id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    quantity DOUBLE NOT NULL,
    price DOUBLE NOT NULL
);
insert into plant(name, type, quantity, price) values ('Rozsa', 'Virag', 30, 30.5),
                                                      ('Karacsonyi kaktusz', 'Kaktusz', 24, 4.5),
                                                      ('Fuszeres bazsalikom', 'Fuszeres noveny', 14, 45);
