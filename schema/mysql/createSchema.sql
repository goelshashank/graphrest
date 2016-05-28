CREATE DATABASE IF NOT EXISTS testdb;
use testdb;
DROP TABLE IF EXISTS users;
CREATE  TABLE users (
  userid int(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  age VARCHAR(255) NOT NULL,
  sex VARCHAR(60) NOT NULL ,
    location VARCHAR(60) NOT NULL ,
  PRIMARY KEY (userid));

INSERT INTO users(name,age,sex,location)
VALUES ('linh','24','male', 'marathalli');
INSERT INTO users(name,age,sex,location)
VALUES ('beecher','25','female', 'jpnagar');


DROP TABLE IF EXISTS relationships;
CREATE  TABLE relationships (
  edgeid int(11) NOT NULL AUTO_INCREMENT,
  fromuserid int(11) ,
   touserid int(11) ,
  relation VARCHAR(60) NOT NULL  ,
  PRIMARY KEY (edgeid));


INSERT INTO relationships(fromuserid,touserid,relation)
VALUES (1,2,'friend');