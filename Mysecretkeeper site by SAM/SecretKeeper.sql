CREATE DATABASE Secretkeeper  ;
USE Secretkeeper ;

CREATE TABLE users (
    id int AUTO_INCREMENT PRIMARY KEY  ,
    nom varchar(40),
    prenom varchar(40),
    username varchar(10),
    mot_de_passe char(32),
    mysecret  text 
);


INSERT INTO users(nom,prenom,username,mot_de_passe,mysecret) VALUES ("Mbacke","Sokhna","SAM","0b4e7a0e5fe84ad35fb5f95b9ceeac79","i'm food lover");
INSERT INTO users(nom,prenom,username,mot_de_passe,mysecret) VALUES ("Drame","Khadija","KBD","65f8577e2e350b5dde4e0bebe32d7460","i'm a knitting lover");
INSERT INTO users(nom,prenom,username,mot_de_passe,mysecret) VALUES ("Cisse","Fatima","fC12","501889830079788034ad6e31821cba3b","pink is my favorite");

CREATE USER secretadmin IDENTIFIED BY 'notfound';
GRANT All PRIVILEGES ON Secretkeeper.* to secretadmin ; 