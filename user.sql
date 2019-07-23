CREATE USER 'react-full-stack' IDENTIFIED BY 'Password1';

create database `react-full-stack`;


GRANT ALL PRIVILEGES ON `react-full-stack`.* TO 'react-full-stack';


SELECT* FROM mysql.user 