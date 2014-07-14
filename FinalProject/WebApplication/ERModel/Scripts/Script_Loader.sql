-- -----------------------------------------------------
-- Table `AhorcaTooth`.`LANGUAGES`
-- -----------------------------------------------------
-- INSERT INTO `AhorcaTooth`.`LANGUAGES` (`iso_code`, `tongue`, `description`)
--    VALUES (NULL, NULL, NULL);

BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`LANGUAGES` (`iso_code`, `tongue`, `description`)
    VALUES ('eng', 'English', '[ENG] Language family: Indo-European. ISO 639-2/T: eng. ISO 639-2/B: eng. ISO 639-3: eng. ISO 639-6: engs.');
INSERT INTO `AhorcaTooth`.`LANGUAGES` (`iso_code`, `tongue`, `description`)
    VALUES ('spa', 'Spanish', '[SPA] Language family: Indo-European. (Castillian). ISO 639-2/T: spa. ISO 639-2/B: spa. ISO 639-3: spa.');
COMMIT;

-- -----------------------------------------------------
-- Table `AhorcaTooth`.`CATEGORY`
-- -----------------------------------------------------
-- INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
--    VALUES (NULL, NULL, NULL, NULL);

BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('COMIDAS', 'spa', 'ic_foods_category.png', 'Comidas famosas en el mundo.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('FOODS', 'eng', 'ic_foods_category.png', 'Famous Foods arround the world.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('DEPORTES', 'spa', 'ic_sports_category.png', 'Deportes importantes hoy en día.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('SPORTS', 'eng', 'ic_sports_category.png', 'Important Sports nowadays.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('GEOGRAFIA', 'spa', 'ic_geography_category.png', 'Lugares, paises, continentes y otros.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('GEOGRAPHY', 'eng', 'ic_geography_category.png', 'Places, countries, continents and so on.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('MUSICA', 'spa', 'ic_music_category.png', 'Nombres de géneros y ritmos más sonados.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('MUSIC', 'eng', 'ic_music_category.png', 'Most listened genres and rhythms.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('RELIGIONES', 'spa', 'ic_religions_category.png', 'Religiones con más adeptos en el mundo.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('RELIGIONS', 'eng', 'ic_religions_category.png', 'Religions more followers in the world.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('TECNOLOGIA', 'spa', 'ic_technology_category.png', 'Términos, Software o Hardware de uso común.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('TECHNOLOGY', 'eng', 'ic_technology_category.png', 'Terms, Software or Hardware commonly used.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('VERBOS', 'spa', 'ic_verbs_category.png', 'Palabras en forma de verbos infinitivos.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('VERBS', 'eng', 'ic_verbs_category.png', 'Words as infinitive verbs.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('NATURALEZA', 'spa', 'ic_nature_category.png', 'Aspectos o elementos referidos a la Naturaleza.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('NATURE', 'eng', 'ic_nature_category.png', 'Aspects or elements referring to the Nature.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('OCIO', 'spa', 'ic_leisure_category.png', 'Hobbies, actividades o acciones del día a día.');
INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
    VALUES ('LEISURE', 'eng', 'ic_leisure_category.png', 'Hobbies, activities or actions in the everyday.');
COMMIT;

-- | EDUCACION  | ic_education_category.png  |
-- | HOGAR      | ic_home_category.png       |
-- | ROPA       | ic_clothes_category.png    |


-- -----------------------------------------------------
-- Table `AhorcaTooth`.`HANGMAN_WORD`
-- -----------------------------------------------------
-- INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
--    VALUES (NULL, NULL, NULL, NULL);

-- COMIDAS / FOODS
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AGRIO', NULL, 'COMIDAS', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('SOUR', NULL, 'FOODS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CARTA', NULL, 'COMIDAS', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CARTE', NULL, 'FOODS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('HIERBA', NULL, 'COMIDAS', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('GRASS', NULL, 'FOODS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('PROBAR', NULL, 'COMIDAS', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TASTE', NULL, 'FOODS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('SABROSO', NULL, 'COMIDAS', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TASTY', NULL, 'FOODS', 'eng');
COMMIT;

-- DEPORTES / SPORTS
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AUTOMOVILISMO', NULL, 'DEPORTES', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('MOTORSPORT', NULL, 'SPORTS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('BASQUET', NULL, 'DEPORTES', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('BASKETBALL', NULL, 'SPORTS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('ESGRIMA', NULL, 'DEPORTES', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('SWORDPLAY', NULL, 'SPORTS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('KARATE', NULL, 'DEPORTES', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('KARATE', NULL, 'SPORTS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TAEKWONDO', NULL, 'DEPORTES', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TAEKWONDO', NULL, 'SPORTS', 'eng');
COMMIT;

-- GEOGRAFIA / GEOGRAPHY
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AFRICA', NULL, 'GEOGRAFIA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AFRICA', NULL, 'GEOGRAPHY', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AMERICA', NULL, 'GEOGRAFIA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AMERICA', NULL, 'GEOGRAPHY', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CONTINENTE', NULL, 'GEOGRAFIA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CONTINENT', NULL, 'GEOGRAPHY', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('EUROPA', NULL, 'GEOGRAFIA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('EUROPE', NULL, 'GEOGRAPHY', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('OCEANO', NULL, 'GEOGRAFIA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('OCEAN', NULL, 'GEOGRAPHY', 'eng');
COMMIT;

-- MUSICA / MUSIC
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('BALADA', NULL, 'MUSICA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('BALLAD', NULL, 'MUSIC', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CLASICA', NULL, 'MUSICA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CLASSIC', NULL, 'MUSIC', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('RAGGAE', NULL, 'MUSICA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('RAGGAE', NULL, 'MUSIC', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('METAL', NULL, 'MUSICA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('METAL', NULL, 'MUSIC', 'eng');
COMMIT;

-- RELIGIONES / RELIGIONS
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('BUDISMO', NULL, 'RELIGIONES', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('BUDDHISM', NULL, 'RELIGIONS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CRISTIANISMO', NULL, 'RELIGIONES', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CHRISTIANITY', NULL, 'RELIGIONS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('HINDUISMO', NULL, 'RELIGIONES', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('HINDUISM', NULL, 'RELIGIONS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('LUTERANISMO', NULL, 'RELIGIONES', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('LUTHERANISM', NULL, 'RELIGIONS', 'eng');
COMMIT;

-- TECNOLOGIA / TECHNOLOGY
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CELULAR', NULL, 'TECNOLOGIA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CELLPHONE', NULL, 'TECHNOLOGY', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('IMPRESORA', NULL, 'TECNOLOGIA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('PRINTER', NULL, 'TECHNOLOGY', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('INTERNET', NULL, 'TECNOLOGIA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('INTERNET', NULL, 'TECHNOLOGY', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TECLADO', NULL, 'TECNOLOGIA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('KEYBOARD', NULL, 'TECHNOLOGY', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('VIDEOJUEGO', NULL, 'TECNOLOGIA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('VIDEOGAME', NULL, 'TECHNOLOGY', 'eng');
COMMIT;

-- VERBOS / VERBS
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('JUGAR', NULL, 'VERBOS', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('PLAY', NULL, 'VERBS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('LLAMAR', NULL, 'VERBOS', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CALL', NULL, 'VERBS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('PEDIR', NULL, 'VERBOS', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('DEMAND', NULL, 'VERBS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TOCAR', NULL, 'VERBOS', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TOUCH', NULL, 'VERBS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TRABAJAR', NULL, 'VERBOS', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('WORK', NULL, 'VERBS', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('NADAR', NULL, 'VERBOS', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('SWIM', NULL, 'VERBS', 'eng');
COMMIT;

-- NATURALEZA / NATURE
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('ALUD', NULL, 'NATURALEZA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AVALANCHE', NULL, 'NATURE', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CONEJO', NULL, 'NATURALEZA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('RABBIT', NULL, 'NATURE', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('LLUVIOSO', NULL, 'NATURALEZA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('RAINY', NULL, 'NATURE', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TRONCO', NULL, 'NATURALEZA', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TRUNK', NULL, 'NATURE', 'eng');
COMMIT;

-- OCIO / LEISURE
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('APLAUSOS', NULL, 'OCIO', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('APPLAUSE', NULL, 'LEISURE', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('ARTE', NULL, 'OCIO', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('ART', NULL, 'LEISURE', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('HINCHA', NULL, 'OCIO', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('FAN', NULL, 'LEISURE', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('SENTIMENTAL', NULL, 'OCIO', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('EMOTIONAL', NULL, 'LEISURE', 'eng');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TIEMPO', NULL, 'OCIO', 'spa');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TIME', NULL, 'LEISURE', 'eng');
COMMIT;