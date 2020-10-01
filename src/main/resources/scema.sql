-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema monitor_sensor
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `monitor_sensor` ;

-- -----------------------------------------------------
-- Schema monitor_sensor
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `monitor_sensor` DEFAULT CHARACTER SET utf8 ;
USE `monitor_sensor` ;

-- -----------------------------------------------------
-- Table `monitor_sensor`.`sensor_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monitor_sensor`.`sensor_type` ;

CREATE TABLE IF NOT EXISTS `monitor_sensor`.`sensor_type` (
  `id` INT NOT NULL,
  `value` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `monitor_sensor`.`sensor_unit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monitor_sensor`.`sensor_unit` ;

CREATE TABLE IF NOT EXISTS `monitor_sensor`.`sensor_unit` (
  `id` INT NOT NULL,
  `value` VARCHAR(45) NOT NULL,
  `sensor_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `sensor_type_id`
    FOREIGN KEY (`sensor_type_id`)
    REFERENCES `monitor_sensor`.`sensor_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `sensor_type_id_idx` ON `monitor_sensor`.`sensor_unit` (`sensor_type_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `monitor_sensor`.`sensor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monitor_sensor`.`sensor` ;

CREATE TABLE IF NOT EXISTS `monitor_sensor`.`sensor` (
  `id` INT NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  `model` VARCHAR(15) NOT NULL,
  `range_from` INT NOT NULL,
  `range_to` INT NOT NULL,
  `location` VARCHAR(40) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `type_id` INT NOT NULL,
  `unit_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `type_id`
    FOREIGN KEY (`type_id`)
    REFERENCES `monitor_sensor`.`sensor_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `unit_id`
    FOREIGN KEY (`unit_id`)
    REFERENCES `monitor_sensor`.`sensor_unit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `type_id_idx` ON `monitor_sensor`.`sensor` (`type_id` ASC) VISIBLE;

CREATE INDEX `unit_id_idx` ON `monitor_sensor`.`sensor` (`unit_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `monitor_sensor`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monitor_sensor`.`role` ;

CREATE TABLE IF NOT EXISTS `monitor_sensor`.`role` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `monitor_sensor`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monitor_sensor`.`users` ;

CREATE TABLE IF NOT EXISTS `monitor_sensor`.`users` (
  `id` INT NOT NULL,
  `username` VARCHAR(200) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `monitor_sensor`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `role_id_idx` ON `monitor_sensor`.`users` (`role_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;