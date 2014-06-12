-- -----------------------------------------------------
-- Table `AhorcaTooth`.`LANGUAGES`
-- -----------------------------------------------------
-- INSERT INTO `AhorcaTooth`.`LANGUAGES` (`iso_code`, `tongue`, `description`)
--    VALUES (NULL, NULL, NULL);
INSERT INTO `AhorcaTooth`.`LANGUAGES` (`iso_code`, `tongue`, `description`)
    VALUES ('en', 'English', '[EN] Language family: Indo-European. ISO 639-2/T: eng. ISO 639-2/B: eng. ISO 639-3: eng. ISO 639-6: engs.');
INSERT INTO `AhorcaTooth`.`LANGUAGES` (`iso_code`, `tongue`, `description`)
    VALUES ('es', 'Spanish', '[ES] Language family: Indo-European. (Castillian). ISO 639-2/T: spa. ISO 639-2/B: spa. ISO 639-3: spa.');


-- -----------------------------------------------------
-- Table `AhorcaTooth`.`CATEGORY`
-- -----------------------------------------------------
-- INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
--    VALUES (NULL, NULL, NULL, NULL);
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('COMIDAS', 'es', 'ic_foods_category.png', 'Comidas famosas en el mundo.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('FOODS', 'en', 'ic_foods_category.png', 'Famous Foods arround the world.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('DEPORTES', 'es', 'ic_sports_category.png', 'Deportes importantes hoy en día.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('SPORTS', 'en', 'ic_sports_category.png', 'Important Sports nowadays.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('GEOGRAFIA', 'es', 'ic_geography_category.png', 'Lugares, paises, continentes y otros.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('GEOGRAPHY', 'en', 'ic_geography_category.png', 'Places, countries, continents and so on.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('MUSICA', 'es', 'ic_music_category.png', 'Nombres de géneros y ritmos más sonados.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('MUSIC', 'en', 'ic_music_category.png', 'Most listened genres and rhythms.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('RELIGIONES', 'es', 'ic_religions_category.png', 'Religiones con más adeptos en el mundo.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('RELIGIONS', 'en', 'ic_religions_category.png', 'Religions more followers in the world.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('TECNOLOGIA', 'es', 'ic_technology_category.png', 'Términos, Software o Hardware de uso común.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('TECHNOLOGY', 'en', 'ic_technology_category.png', 'Terms, Software or Hardware commonly used.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('VERBOS', 'es', 'ic_verbs_category.png', 'Palabras en forma de verbos infinitivos.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('VERBS', 'en', 'ic_verbs_category.png', 'Words as infinitive verbs.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('NATURALEZA', 'es', 'ic_nature_category.png', 'Aspectos o elementos referidos a la Naturaleza.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('NATURE', 'en', 'ic_nature_category.png', 'Aspects or elements referring to the Nature.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('OCIO', 'es', 'ic_leisure_category.png', 'Hobbies, actividades o acciones del día a día.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('LEISURE', 'en', 'ic_leisure_category.png', 'Hobbies, activities or actions in the everyday.');

--| EDUCACION  | ic_education_category.png  |
--| HOGAR      | ic_home_category.png       |
--| ROPA       | ic_clothes_category.png    |


-- -----------------------------------------------------
-- Table `AhorcaTooth`.`HANGMAN_WORD`
-- -----------------------------------------------------
-- INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
--    VALUES (NULL, NULL, NULL, NULL);
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('', NULL, NULL, NULL);