SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema teachersCatalog
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS teachersCatalog DEFAULT CHARACTER SET utf8 ;
USE teachersCatalog ;

-- -----------------------------------------------------
-- Table teachersCatalog.`teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS teachersCatalog.`teacher` (
  idTeacher INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  surname VARCHAR(45) NOT NULL,
  rfc VARCHAR(45) NOT NULL,
  PRIMARY KEY (idTeacher)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table teachersCatalog.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS teachersCatalog.`user` (
  idUser INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  isAdmin INT(11) NOT NULL,
  idTeacher INT(11) NOT NULL,
  PRIMARY KEY (idUser),
  INDEX idTeacher_idx (idTeacher ASC),
  CONSTRAINT idTeacher
    FOREIGN KEY (idTeacher)
    REFERENCES teachersCatalog.`teacher` (idTeacher)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table teachersCatalog.`learningUnit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS teachersCatalog.`learningUnit` (
  idLearningUnit INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  classHours INT(11) NOT NULL,
  workshopHours INT(11) NOT NULL,
  laboratoryHours INT(11) NOT NULL,
  PRIMARY KEY (idLearningUnit)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table teachersCatalog.`teacher_learningUnit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS teachersCatalog.`teacher_learningUnit` (
  idTeacher INT(11) NOT NULL,
  idLearningUnit INT(11) NOT NULL,
  PRIMARY KEY (idTeacher, idLearningUnit),
  INDEX idLearningUnit_idx (idLearningUnit ASC),useruser
  CONSTRAINT idTeacher_fk
    FOREIGN KEY (idTeacher)
    REFERENCES teachersCatalog.`teacher` (idTeacher)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT idLearningUnit_fk
    FOREIGN KEY (idLearningUnit)
    REFERENCES teachersCatalog.`learningUnit` (idLearningUnit)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;