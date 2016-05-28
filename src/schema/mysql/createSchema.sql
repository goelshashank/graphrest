CREATE DATABASE IF NOT EXISTS testdb;
use testdb;
DROP TABLE IF EXISTS users;
CREATE  TABLE users (
  userid int(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL UNIQUE,
  age VARCHAR(255) NOT NULL,
  sex VARCHAR(60) NOT NULL ,
    location VARCHAR(60) NOT NULL ,
  PRIMARY KEY (userid));

INSERT INTO users(name,age,sex,location)
VALUES ('user1','24','male', 'marathalli');
INSERT INTO users(name,age,sex,location)
VALUES ('user2','25','female', 'jpnagar');
INSERT INTO users(name,age,sex,location)
VALUES ('user3','25','female', 'jpnagar1');
INSERT INTO users(name,age,sex,location)
VALUES ('user4','27','male', 'jpnagar2');
INSERT INTO users(name,age,sex,location)
VALUES ('user5','28','male', 'jpnagar3');
INSERT INTO users(name,age,sex,location)
VALUES ('user6','29','male', 'jpnagar4');
INSERT INTO users(name,age,sex,location)
VALUES ('user7','30','male', 'jpnagar5');


DROP TABLE IF EXISTS relationships;
CREATE  TABLE relationships (
  edgeid int(11) NOT NULL AUTO_INCREMENT,
  fromuserid int(11) ,
   touserid int(11) ,
  relation VARCHAR(60) NOT NULL  ,
  PRIMARY KEY (edgeid));


INSERT INTO relationships(fromuserid,touserid,relation)
VALUES (1,2,'friend');
INSERT INTO relationships(fromuserid,touserid,relation)
VALUES (2,3,'friend');
INSERT INTO relationships(fromuserid,touserid,relation)
VALUES (4,5,'friend');
INSERT INTO relationships(fromuserid,touserid,relation)
VALUES (5,1,'friend');
INSERT INTO relationships(fromuserid,touserid,relation)
VALUES (3,6,'friend');