DROP DATABASE IF EXISTS `UNIVERSITY`;

CREATE DATABASE `UNIVERSITY`;

USE `UNIVERSITY`;

DROP TABLE IF EXISTS `DEPARTMENT`;

CREATE TABLE `DEPARTMENT` (
	`DE_NUM`	CHAR(3) PRIMARY KEY	NOT NULL,
	`DE_NAME`	VARCHAR(50) NOT	NULL,
	`DE_OFFICE`	VARCHAR(255)	NULL,
    `DE_NAME_NUM` CHAR(3) UNIQUE NOT NULL,
	`DE_PR_NUM`	CHAR(11)	
);

DROP TABLE IF EXISTS `PROFESSOR`;

CREATE TABLE `PROFESSOR` (
	`PR_NUM`	CHAR(11)  PRIMARY KEY	NOT NULL,
	`PR_NAME`	VARCHAR(50) NOT	NULL,
	`PR_PHONE`	VARCHAR(13) NOT	NULL,
	`PR_RES_NUM`	CHAR(14) UNIQUE NOT	NULL,
	`PR_YEAR`	INT NOT	NULL,
	`PR_DE_NUM`	CHAR(3)	NOT NULL
);

DROP TABLE IF EXISTS `STUDENT`;

CREATE TABLE `STUDENT` (
	`ST_NUM`	CHAR(10)  PRIMARY KEY	NOT NULL,
	`ST_NAME`	VARCHAR(50) NOT	NULL,
	`ST_RES_NUM`	CHAR(14) UNIQUE NOT	NULL,
	`ST_PHONE`	VARCHAR(13) NOT	NULL,
	`ST_YEAR`	INT NOT	NULL,
	`ST_DE_NUM`	CHAR(3)	NOT NULL,
	`ST_PR_NUM`	CHAR(11) NULL
);

DROP TABLE IF EXISTS `FINAL_PASS`;

CREATE TABLE `FINAL_PASS` (
	`FP_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`FP_NAME`	VARCHAR(50) NOT	NULL,
	`FP_PHONE`	VARCHAR(13) NOT	NULL,
	`FP_YEAR`	INT NOT	NULL,
	`FP_RES_NUM`	CHAR(14) NOT	NULL,
	`FP_DE_NUM`	CHAR(3)	NOT NULL
);

DROP TABLE IF EXISTS `SUBJECT`;

CREATE TABLE `SUBJECT` (
	`SJ_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`SJ_TITLE`	VARCHAR(50) NOT	NULL,
	`SJ_POINT`	INT  DEFAULT 0 NOT	NULL,
	`SJ_TIME`	INT  DEFAULT 0 NOT	NULL,
	`SJ_CODE`	CHAR(6) UNIQUE NOT	NULL,
	`SJ_SC_CODE`	CHAR(3)	NOT NULL
);

DROP TABLE IF EXISTS `SUBJECT_CATEGORY`;

CREATE TABLE `SUBJECT_CATEGORY` (
	`SC_CODE`	CHAR(3)  PRIMARY KEY	NOT NULL
);

DROP TABLE IF EXISTS `LECTURE`;

CREATE TABLE `LECTURE` (
	`LE_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`LE_YEAR`	INT NOT	NULL,
	`LE_SEMESTER`	ENUM("1","2","여름","겨울") NOT	NULL,
	`LE_CLASS_ROOM`	VARCHAR(255)	NULL,
	`LE_CLASS`	INT  DEFAULT 1 NOT	NULL,
	`LE_MAX`	INT NOT	NULL,
	`LE_PLAN`	LONGTEXT	NULL,
	`LE_SJ_NUM`	INT	NOT NULL,
	`LE_PR_NUM`	CHAR(11)	NOT NULL
);

DROP TABLE IF EXISTS `LECTURE_SCHEDULE`;

CREATE TABLE `LECTURE_SCHEDULE` (
	`LC_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`LC_DAY`	CHAR(1) NOT	NULL,
	`LC_TIME`	VARCHAR(2) NOT	NULL,
	`LC_MINUTE`	CHAR(1) NOT	NULL,
	`LC_LE_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `LECTURE_STANDARD`;

CREATE TABLE `LECTURE_STANDARD` (
	`LS_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`LS_MID`	INT  DEFAULT 35 NOT	NULL,
	`LS_FINAL`	INT  DEFAULT 45 NOT	NULL,
	`LS_HOME`	INT  DEFAULT 10 NOT	NULL,
	`LS_ATT`	INT  DEFAULT 10 NOT	NULL,
	`LS_LE_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `COURSE`;

CREATE TABLE `COURSE` (
	`CO_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`CO_ATT`	INT DEFAULT 0 NOT	NULL,
	`CO_HOME`	INT DEFAULT 0 NOT	NULL,
	`CO_MID`	INT  DEFAULT 0 NOT	NULL,
	`CO_FINAL`	INT  DEFAULT 0 NOT	NULL,
	`CO_TOTAL`	VARCHAR(4)	NULL,
	`CO_ST_NUM`	CHAR(10)	NOT NULL,
	`CO_LE_NUM`	INT	NOT NULL
);


ALTER TABLE `DEPARTMENT` ADD CONSTRAINT `FK_PROFESSOR_TO_DEPARTMENT_1` FOREIGN KEY (
	`DE_PR_NUM`
)
REFERENCES `PROFESSOR` (
	`PR_NUM`
);

ALTER TABLE `PROFESSOR` ADD CONSTRAINT `FK_DEPARTMENT_TO_PROFESSOR_1` FOREIGN KEY (
	`PR_DE_NUM`
)
REFERENCES `DEPARTMENT` (
	`DE_NUM`
);

ALTER TABLE `STUDENT` ADD CONSTRAINT `FK_DEPARTMENT_TO_STUDENT_1` FOREIGN KEY (
	`ST_DE_NUM`
)
REFERENCES `DEPARTMENT` (
	`DE_NUM`
);

ALTER TABLE `STUDENT` ADD CONSTRAINT `FK_PROFESSOR_TO_STUDENT_1` FOREIGN KEY (
	`ST_PR_NUM`
)
REFERENCES `PROFESSOR` (
	`PR_NUM`
);

ALTER TABLE `FINAL_PASS` ADD CONSTRAINT `FK_DEPARTMENT_TO_FINAL_PASS_1` FOREIGN KEY (
	`FP_DE_NUM`
)
REFERENCES `DEPARTMENT` (
	`DE_NUM`
);

ALTER TABLE `SUBJECT` ADD CONSTRAINT `FK_SUBJECT_CATEGORY_TO_SUBJECT_1` FOREIGN KEY (
	`SJ_SC_CODE`
)
REFERENCES `SUBJECT_CATEGORY` (
	`SC_CODE`
);

ALTER TABLE `LECTURE` ADD CONSTRAINT `FK_SUBJECT_TO_LECTURE_1` FOREIGN KEY (
	`LE_SJ_NUM`
)
REFERENCES `SUBJECT` (
	`SJ_NUM`
);

ALTER TABLE `LECTURE` ADD CONSTRAINT `FK_PROFESSOR_TO_LECTURE_1` FOREIGN KEY (
	`LE_PR_NUM`
)
REFERENCES `PROFESSOR` (
	`PR_NUM`
);

ALTER TABLE `LECTURE_SCHEDULE` ADD CONSTRAINT `FK_LECTURE_TO_LECTURE_SCHEDULE_1` FOREIGN KEY (
	`LC_LE_NUM`
)
REFERENCES `LECTURE` (
	`LE_NUM`
);

ALTER TABLE `LECTURE_STANDARD` ADD CONSTRAINT `FK_LECTURE_TO_LECTURE_STANDARD_1` FOREIGN KEY (
	`LS_LE_NUM`
)
REFERENCES `LECTURE` (
	`LE_NUM`
);

ALTER TABLE `COURSE` ADD CONSTRAINT `FK_STUDENT_TO_COURSE_1` FOREIGN KEY (
	`CO_ST_NUM`
)
REFERENCES `STUDENT` (
	`ST_NUM`
);

ALTER TABLE `COURSE` ADD CONSTRAINT `FK_LECTURE_TO_COURSE_1` FOREIGN KEY (
	`CO_LE_NUM`
)
REFERENCES `LECTURE` (
	`LE_NUM`
);