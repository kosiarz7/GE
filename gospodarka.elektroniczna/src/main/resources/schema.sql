CREATE DATABASE IF NOT EXISTS GE DEFAULT CHARACTER SET utf8;
USE GE;

CREATE TABLE LAST_SIGNATURE (
	ID INT NOT NULL,
	SIGNATURE VARCHAR(10) NOT NULL,
	PRIMARY KEY (ID)
);

COMMIT;