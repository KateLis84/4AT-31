CREATE SCHEMA `aqa_step` ;
CREATE TABLE `aqa_step`.`user` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `LastName` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `age` INT NULL,
  PRIMARY KEY (`idUser`));
