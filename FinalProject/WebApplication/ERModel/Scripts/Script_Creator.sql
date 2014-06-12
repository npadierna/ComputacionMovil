SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `AhorcaTooth` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `AhorcaTooth` ;

-- -----------------------------------------------------
-- Table `AhorcaTooth`.`LANGUAGES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `AhorcaTooth`.`LANGUAGES` (
  `iso_code` VARCHAR(2) NOT NULL COMMENT 'Agree with: ISO 639-1' ,
  `tongue` VARCHAR(25) NOT NULL ,
  `description` VARCHAR(250) NULL ,
  PRIMARY KEY (`iso_code`) ,
  UNIQUE INDEX `ISO_CODE_UNIQUE` (`iso_code` ASC) ,
  UNIQUE INDEX `TONGUE_UNIQUE` (`tongue` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AhorcaTooth`.`WORD`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `AhorcaTooth`.`WORD` (
  `word_name` VARCHAR(15) NOT NULL ,
  `description` VARCHAR(250) NULL ,
  PRIMARY KEY (`word_name`) ,
  UNIQUE INDEX `WORD_NAME_UNIQUE` (`word_name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AhorcaTooth`.`CATEGORY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `AhorcaTooth`.`CATEGORY` (
  `category_name` VARCHAR(25) NOT NULL ,
  `image_name` VARCHAR(35) NOT NULL ,
  `description` VARCHAR(250) NULL ,
  PRIMARY KEY (`category_name`) ,
  UNIQUE INDEX `category_name_UNIQUE` (`category_name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AhorcaTooth`.`HANGMAN_WORD`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `AhorcaTooth`.`HANGMAN_WORD` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `iso_code` VARCHAR(2) NOT NULL ,
  `word_name` VARCHAR(15) NOT NULL ,
  `category_name` VARCHAR(25) NOT NULL ,
  INDEX `fk_table1_WORD1_idx` (`word_name` ASC) ,
  INDEX `fk_LANGUAGE_WORD_CATEGORY1_idx` (`category_name` ASC) ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  CONSTRAINT `fk_table1_LANGUAGE`
    FOREIGN KEY (`iso_code` )
    REFERENCES `AhorcaTooth`.`LANGUAGES` (`iso_code` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_WORD1`
    FOREIGN KEY (`word_name` )
    REFERENCES `AhorcaTooth`.`WORD` (`word_name` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LANGUAGE_WORD_CATEGORY1`
    FOREIGN KEY (`category_name` )
    REFERENCES `AhorcaTooth`.`CATEGORY` (`category_name` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `AhorcaTooth` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
