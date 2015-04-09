CREATE DATABASE IF NOT EXISTS GE DEFAULT CHARACTER SET utf8;
USE GE;

-- UŻYTKOWNICY

CREATE TABLE USERS (
	ID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(50) NOT NULL,
	SURNAME VARCHAR(100) NOT NULL,
	LOGIN VARCHAR(100) NOT NULL,
	PASSWORD VARCHAR(512) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE ROLES (
	ID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(50) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE USER_ROLES (
	ID INT NOT NULL AUTO_INCREMENT,
	USER_ID INT NOT NULL,
	ROLE_ID INT NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY USER_ROLES_USER_FK(USER_ID) REFERENCES USERS(ID),
	FOREIGN KEY USER_ROLES_ROLE_FK(ROLE_ID) REFERENCES ROLES(ID)
);

-- DOKUMENTY

CREATE TABLE LAST_SIGNATURE (
	ID INT NOT NULL,
	SIGNATURE VARCHAR(10) NOT NULL,
	PRIMARY KEY (ID)
);

COMMIT;