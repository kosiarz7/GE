CREATE DATABASE IF NOT EXISTS GE DEFAULT CHARACTER SET utf8;
USE GE;

-- UŻYTKOWNICY

CREATE TABLE IF NOT EXISTS USERS (
	ID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(50) NOT NULL,
	SURNAME VARCHAR(100) NOT NULL,
	LOGIN VARCHAR(100) NOT NULL,
	PASSWORD VARCHAR(128) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS ROLES (
	ID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(50) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS USER_ROLES (
	ID INT NOT NULL AUTO_INCREMENT,
	USER_ID INT NOT NULL,
	ROLE_ID INT NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY USER_ROLES_00_USER_FK(USER_ID) REFERENCES USERS(ID),
	FOREIGN KEY USER_ROLES_00_ROLE_FK(ROLE_ID) REFERENCES ROLES(ID)
);

COMMIT;

-- DOKUMENTY

CREATE TABLE IF NOT EXISTS LAST_SIGNATURE (
	ID INT NOT NULL AUTO_INCREMENT,
	SIGNATURE VARCHAR(15) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS DEPARTMENTS (
	ID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT DEPARTMENTS_00_DEPARTMENT_NAME_HAS_TO_BE_UNIQUE UNIQUE (NAME)
);

CREATE TABLE IF NOT EXISTS DOCUMENT_TYPES (
	ID INT NOT NULL AUTO_INCREMENT,
	TYPE_NAME VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT DOCUMENT_TYPES_00_DOCUMENT_TYPE_NAME_HAS_TO_BE_UNIQUE UNIQUE (TYPE_NAME)
);

COMMIT;

CREATE TABLE IF NOT EXISTS DOCUMENT_HEADERS (
	ID INT NOT NULL AUTO_INCREMENT,
	TITLE VARCHAR(512) NOT NULL,
	SIGNATURE VARCHAR(15) NOT NULL,
	TYPE_ID INT NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY DOCUMENT_HEADER_00_TYPE_FK(TYPE_ID) REFERENCES DOCUMENT_TYPES(ID)
);

CREATE TABLE IF NOT EXISTS CURRENT_DOCUMENTS (
	ID INT NOT NULL AUTO_INCREMENT,
	HEADER_ID INT NOT NULL,
	SOURCE_DEPARTMENT_ID INT NOT NULL, -- dział, z którego wyszedł dokument
	TARGET_DEPARTMENT_ID INT NOT NULL, -- dział, do którego dotarł dokument
	DATE_OF_RECIPT TIMESTAMP NOT NULL, -- data wpłynięcia dokumentu do docelowego działu
	CONTENT LONGBLOB NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY CURRENT_DOCUMENTS_00_HEADER_ID_FK(HEADER_ID) REFERENCES DOCUMENT_HEADERS(ID),
	FOREIGN KEY CURRENT_DOCUMENTS_00_SOURCE_DEPARTMENT_ID_FK(SOURCE_DEPARTMENT_ID) REFERENCES DEPARTMENTS(ID),
	FOREIGN KEY CURRENT_DOCUMENTS_00_TARGET_DEPARTMENT_ID_FK(TARGET_DEPARTMENT_ID) REFERENCES DEPARTMENTS(ID)
);

CREATE TABLE IF NOT EXISTS ARCHIVAL_DOCUMENTS (
	ID INT NOT NULL AUTO_INCREMENT,
	HEADER_ID INT NOT NULL,
	SOURCE_DEPARTMENT_ID INT NOT NULL,
	TARGET_DEPARTMENT_ID INT NOT NULL,
	DATE_OF_RECIPT TIMESTAMP NOT NULL, -- data otrzymania dokumentu przez docelowy oddział
	DATE_OF_DISPATCH TIMESTAMP NOT NULL, -- data przetworzenia dokumentu przez docelowy oddział (przesłanie go dalej, przeniesienie do archiwum itd.)
	CONTENT LONGBLOB NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY ARCHIVAL_DOCUMENTS_00_HEADER_ID_FK(HEADER_ID) REFERENCES DOCUMENT_HEADERS(ID),
	FOREIGN KEY ARCHIVAL_DOCUMENTS_00_SOURCE_DEPARTMENT_ID_FK(SOURCE_DEPARTMENT_ID) REFERENCES DEPARTMENTS(ID),
	FOREIGN KEY ARCHIVAL_DOCUMENTS_00_TARGET_DEPARTMENT_ID_FK(TARGET_DEPARTMENT_ID) REFERENCES DEPARTMENTS(ID)
);

COMMIT;