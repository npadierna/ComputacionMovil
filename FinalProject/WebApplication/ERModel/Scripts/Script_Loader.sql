-- -----------------------------------------------------
-- Table `AhorcaTooth`.`LANGUAGES`
-- -----------------------------------------------------
-- INSERT INTO `AhorcaTooth`.`LANGUAGES` (`iso_code`, `tongue`, `description`)
--    VALUES (NULL, NULL, NULL);

BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`LANGUAGES` (`iso_code`, `tongue`, `description`)
    VALUES ('en', 'English', '[EN] Language family: Indo-European. ISO 639-2/T: eng. ISO 639-2/B: eng. ISO 639-3: eng. ISO 639-6: engs.');
INSERT INTO `AhorcaTooth`.`LANGUAGES` (`iso_code`, `tongue`, `description`)
    VALUES ('es', 'Spanish', '[ES] Language family: Indo-European. (Castillian). ISO 639-2/T: spa. ISO 639-2/B: spa. ISO 639-3: spa.');
COMMIT;

-- -----------------------------------------------------
-- Table `AhorcaTooth`.`CATEGORY`
-- -----------------------------------------------------
-- INSERT INTO `AhorcaTooth`.`CATEGORY` (`category_name`, `languages_iso_code`, `image_name`, `description`)
--    VALUES (NULL, NULL, NULL, NULL);

BEGIN TRANSACTION;
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
    VALUES ('AGRIO', NULL, 'COMIDAS', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('SOUR', NULL, 'FOODS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CARTA', NULL, 'COMIDAS', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CARTE', NULL, 'FOODS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('HIERBA', NULL, 'COMIDAS', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('GRASS', NULL, 'FOODS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('PROBAR', NULL, 'COMIDAS', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TASTE', NULL, 'FOODS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('SABROSO', NULL, 'COMIDAS', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TASTY', NULL, 'FOODS', 'en');
COMMIT;

-- DEPORTES / SPORTS
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AUTOMOVILISMO', NULL, 'DEPORTES', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('MOTORSPORT', NULL, 'SPORTS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('BASQUET', NULL, 'DEPORTES', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('BASKETBALL', NULL, 'SPORTS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('ESGRIMA', NULL, 'DEPORTES', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('SWORDPLAY', NULL, 'SPORTS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('KARATE', NULL, 'DEPORTES', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('KARATE', NULL, 'SPORTS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TAEKWONDO', NULL, 'DEPORTES', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TAEKWONDO', NULL, 'SPORTS', 'en');
COMMIT;

-- GEOGRAFIA / GEOGRAPHY
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AFRICA', NULL, 'GEOGRAFIA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AFRICA', NULL, 'GEOGRAPHY', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AMERICA', NULL, 'GEOGRAFIA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AMERICA', NULL, 'GEOGRAPHY', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CONTINENTE', NULL, 'GEOGRAFIA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CONTINENT', NULL, 'GEOGRAPHY', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('EUROPA', NULL, 'GEOGRAFIA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('EUROPE', NULL, 'GEOGRAPHY', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('OCEANO', NULL, 'GEOGRAFIA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('OCEAN', NULL, 'GEOGRAPHY', 'en');
COMMIT;

-- MUSICA / MUSIC
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('BALADA', NULL, 'MUSICA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('BALLAD', NULL, 'MUSIC', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CLASICA', NULL, 'MUSICA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CLASSIC', NULL, 'MUSIC', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('RAGGAE', NULL, 'MUSICA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('RAGGAE', NULL, 'MUSIC', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('METAL', NULL, 'MUSICA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('METAL', NULL, 'MUSIC', 'en');
COMMIT;

-- RELIGIONES / RELIGIONS
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('BUDISMO', NULL, 'RELIGIONES', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('BUDDHISM', NULL, 'RELIGIONS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CRISTIANISMO', NULL, 'RELIGIONES', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CHRISTIANITY', NULL, 'RELIGIONS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('HINDUISMO', NULL, 'RELIGIONES', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('HINDUISM', NULL, 'RELIGIONS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('LUTERANISMO', NULL, 'RELIGIONES', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('LUTHERANISM', NULL, 'RELIGIONS', 'en');
COMMIT;

-- TECNOLOGIA / TECHNOLOGY
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CELULAR', NULL, 'TECNOLOGIA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CELLPHONE', NULL, 'TECHNOLOGY', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('IMPRESORA', NULL, 'TECNOLOGIA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('PRINTER', NULL, 'TECHNOLOGY', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('INTERNET', NULL, 'TECNOLOGIA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('INTERNET', NULL, 'TECHNOLOGY', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TECLADO', NULL, 'TECNOLOGIA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('KEYBOARD', NULL, 'TECHNOLOGY', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('VIDEOJUEGO', NULL, 'TECNOLOGIA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('VIDEOGAME', NULL, 'TECHNOLOGY', 'en');
COMMIT;

-- VERBOS / VERBS
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('JUGAR', NULL, 'VERBOS', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('PLAY', NULL, 'VERBS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('LLAMAR', NULL, 'VERBOS', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CALL', NULL, 'VERBS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('PEDIR', NULL, 'VERBOS', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('DEMAND', NULL, 'VERBS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TOCAR', NULL, 'VERBOS', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TOUCH', NULL, 'VERBS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TRABAJAR', NULL, 'VERBOS', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('WORK', NULL, 'VERBS', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('NADAR', NULL, 'VERBOS', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('SWIM', NULL, 'VERBS', 'en');
COMMIT;

-- NATURALEZA / NATURE
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('ALUD', NULL, 'NATURALEZA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('AVALANCHE', NULL, 'NATURE', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('CONEJO', NULL, 'NATURALEZA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('RABBIT', NULL, 'NATURE', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('LLUVIOSO', NULL, 'NATURALEZA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('RAINY', NULL, 'NATURE', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TRONCO', NULL, 'NATURALEZA', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TRUNK', NULL, 'NATURE', 'en');
COMMIT;

-- OCIO / LEISURE
BEGIN TRANSACTION;
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('APLAUSOS', NULL, 'OCIO', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('APPLAUSE', NULL, 'LEISURE', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('ARTE', NULL, 'OCIO', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('ART', NULL, 'LEISURE', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('HINCHA', NULL, 'OCIO', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('FAN', NULL, 'LEISURE', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('SENTIMENTAL', NULL, 'OCIO', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('EMOTIONAL', NULL, 'LEISURE', 'en');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TIEMPO', NULL, 'OCIO', 'es');
INSERT INTO `AhorcaTooth`.`HANGMAN_WORD` (`word_name`, `description`, `category_name`, `languages_iso_code`)
    VALUES ('TIME', NULL, 'LEISURE', 'en');
COMMIT;