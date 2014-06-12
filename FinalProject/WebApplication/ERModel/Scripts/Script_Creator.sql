SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `AhorcaTooth` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `AhorcaTooth` ;

-- -----------------------------------------------------
-- Table `AhorcaTooth`.`LANGUAGES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `AhorcaTooth`.`LANGUAGES` (
  `iso_code` VARCHAR(3) NOT NULL COMMENT 'Agree with: ISO 639-1' ,
  `tongue` VARCHAR(25) NOT NULL ,
  `description` VARCHAR(250) NULL ,
  PRIMARY KEY (`iso_code`) ,
  UNIQUE INDEX `ISO_CODE_UNIQUE` (`iso_code` ASC) ,
  UNIQUE INDEX `TONGUE_UNIQUE` (`tongue` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AhorcaTooth`.`CATEGORY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `AhorcaTooth`.`CATEGORY` (
  `category_name` VARCHAR(25) NOT NULL ,
  `languages_iso_code` VARCHAR(3) NOT NULL ,
  `image_name` VARCHAR(35) NOT NULL ,
  `description` VARCHAR(250) NULL ,
  PRIMARY KEY (`category_name`, `languages_iso_code`) ,
  UNIQUE INDEX `category_name_UNIQUE` (`category_name` ASC) ,
  INDEX `fk_CATEGORY_LANGUAGES_idx` (`languages_iso_code` ASC) ,
  UNIQUE INDEX `languages_iso_code_UNIQUE` (`languages_iso_code` ASC) ,
  CONSTRAINT `fk_CATEGORY_LANGUAGES`
    FOREIGN KEY (`languages_iso_code` )
    REFERENCES `AhorcaTooth`.`LANGUAGES` (`iso_code` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AhorcaTooth`.`HANGMAN_WORD`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `AhorcaTooth`.`HANGMAN_WORD` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `word_name` VARCHAR(15) NOT NULL ,
  `description` VARCHAR(250) NULL ,
  `category_name` VARCHAR(25) NOT NULL ,
  `languages_iso_code` VARCHAR(3) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_HANGMAN_WORD_CATEGORY1_idx` (`category_name` ASC, `languages_iso_code` ASC) ,
  CONSTRAINT `fk_HANGMAN_WORD_CATEGORY1`
    FOREIGN KEY (`category_name` , `languages_iso_code` )
    REFERENCES `AhorcaTooth`.`CATEGORY` (`category_name` , `languages_iso_code` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `AhorcaTooth` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
