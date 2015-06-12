-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema emergency
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `emergency` ;

-- -----------------------------------------------------
-- Schema emergency
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `emergency` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `emergency` ;

-- -----------------------------------------------------
-- Table `emergency`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emergency`.`user` ;

CREATE TABLE IF NOT EXISTS `emergency`.`user` (
  `telephone` VARCHAR(20) NOT NULL,
  `nom` VARCHAR(30) NULL,
  `prenom` VARCHAR(30) NULL,
  `date_naissance` DATE NULL,
  `sexe` SMALLINT(1) NULL,
  `group_sanguin` SMALLINT(1) NULL,
  `diabete` SMALLINT(1) NULL,
  `cholesterol` SMALLINT(1) NULL,
  `autres_infos` TEXT(500) NULL,
  `gcm_device_id` VARCHAR(200) NULL,
  `digits_id` BIGINT,
  PRIMARY KEY (`telephone`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `emergency`.`situation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emergency`.`situation` ;

CREATE TABLE IF NOT EXISTS `emergency`.`situation` (
  `id_situation` INT NOT NULL AUTO_INCREMENT,
  `id_emetteur` VARCHAR(20) NOT NULL,
  `titre` VARCHAR(45) NOT NULL,
  `message` TEXT(300) NULL,
  `pieces_jointes` SMALLINT(1) NULL,
  `type_envoi` SMALLINT(1) NULL,
  PRIMARY KEY (`id_situation`),
  INDEX `fk_situation_user_idx` (`id_emetteur` ASC),
  CONSTRAINT `fk_situation_user`
    FOREIGN KEY (`id_emetteur`)
    REFERENCES `emergency`.`user` (`telephone`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `emergency`.`alerte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emergency`.`alerte` ;

CREATE TABLE IF NOT EXISTS `emergency`.`alerte` (
  `id_alerte` INT NOT NULL AUTO_INCREMENT,
  `id_situation` INT NOT NULL,
  `date_envoi` DATETIME NULL,
  `localisation_em_x` VARCHAR(45) NULL,
  `localisation_em_y` VARCHAR(45) NULL,
  `statut` SMALLINT(1) NULL,
  PRIMARY KEY (`id_alerte`),
  INDEX `fk_alerte_situation1_idx` (`id_situation` ASC),
  CONSTRAINT `fk_alerte_situation1`
    FOREIGN KEY (`id_situation`)
    REFERENCES `emergency`.`situation` (`id_situation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `emergency`.`suivi_alerte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emergency`.`suivi_alerte` ;

CREATE TABLE IF NOT EXISTS `emergency`.`suivi_alerte` (
  `id_alerte` INT NOT NULL,
  `id_recepteur` VARCHAR(20) NOT NULL,
  `localisation_re_x` VARCHAR(45) NULL,
  `localisation_re_y` VARCHAR(45) NULL,
  `etat_suivi` SMALLINT(1) NULL,
  `date_maj` DATETIME NULL,
  PRIMARY KEY (`id_recepteur`, `id_alerte`),
  INDEX `fk_alerte_has_user_user1_idx` (`id_recepteur` ASC),
  INDEX `fk_alerte_has_user_alerte1_idx` (`id_alerte` ASC),
  CONSTRAINT `fk_alerte_has_user_alerte1`
    FOREIGN KEY (`id_alerte`)
    REFERENCES `emergency`.`alerte` (`id_alerte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alerte_has_user_user1`
    FOREIGN KEY (`id_recepteur`)
    REFERENCES `emergency`.`user` (`telephone`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `emergency`.`recepteurs_situation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emergency`.`recepteurs_situation` ;

CREATE TABLE IF NOT EXISTS `emergency`.`recepteurs_situation` (
  `id_recepteur` VARCHAR(20) NOT NULL,
  `id_situation` INT NOT NULL,
  `date_creation` DATETIME NULL,
  `date_modification` DATETIME NULL,
  PRIMARY KEY (`id_recepteur`, `id_situation`),
  INDEX `fk_user_has_situation_situation1_idx` (`id_situation` ASC),
  CONSTRAINT `fk_user_has_situation_situation1`
    FOREIGN KEY (`id_situation`)
    REFERENCES `emergency`.`situation` (`id_situation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `emergency`.`piece_jointe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emergency`.`piece_jointe` ;

CREATE TABLE IF NOT EXISTS `emergency`.`piece_jointe` (
  `id_piece_jointe` INT NOT NULL AUTO_INCREMENT,
  `id_alerte` INT NOT NULL,
  `url` VARCHAR(100) NULL,
  `date_creation` DATETIME NULL,
  `type` VARCHAR(20) NULL,
  PRIMARY KEY (`id_piece_jointe`),
  INDEX `fk_piece_jointe_alerte1_idx` (`id_alerte` ASC),
  CONSTRAINT `fk_piece_jointe_alerte1`
    FOREIGN KEY (`id_alerte`)
    REFERENCES `emergency`.`alerte` (`id_alerte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
