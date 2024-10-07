/*
Задание 7. В подключенном MySQL репозитории создать базу данных «Друзья человека»
*/
use human_friends;

/*
Задание 8. Создать таблицы с иерархией из диаграммы в БД
*/
--------- Создание таблицы Cats -------------
CREATE TABLE cats (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

--------- Создание таблицы Dogs -------------
CREATE TABLE dogs (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

--------- Создание таблицы Hamsters -------------
CREATE TABLE hamsters (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

--------- Создание таблицы Horses -------------
CREATE TABLE horses (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

--------- Создание таблицы Camels -------------
CREATE TABLE camels (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

--------- Создание таблицы Donkeys -------------
CREATE TABLE donkeys (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

/*
Задание 9. Заполнить низкоуровневые таблицы именами(животных), 
командами, которые они выполняют, и датами рождения.
*/
INSERT INTO cats (animal_name,commands, date_of_birth) VALUES 
	('chika', 'voice', '2020-08-01'),
	('koshka', 'voice, run', '2023-12-10'),
    ('grey', 'voice, sit', '2024-02-02'),
    ('musya', 'voice', '2023-03-03'),
    ('k-pop', 'voice', '2013-06-13');
   
INSERT INTO dogs (animal_name,commands, date_of_birth) VALUES 
	('pollianna', 'voice, run, sit, left paw, right paw', '2023-01-03'),
	('polli', 'sit, paw', '2023-12-10'),
    ('anna', 'sit', '2024-02-02'),
    ('tusik', 'can', '2023-03-03'),
    ('warmer', 'ung', '2013-06-13');
    
INSERT INTO hamsters (animal_name,commands, date_of_birth) VALUES 
	('belyash', 'to me', '2020-08-01'),
	('round', 'eat', '2023-12-10'),
    ('grey', 'to me', '2024-02-02'),
    ('thick', 'eat', '2023-03-03'),
    ('small', 'to me', '2013-06-13');
    
INSERT INTO horses (animal_name,commands, date_of_birth) VALUES 
	('grey', 'eat, run, left paw, right paw', '2020-08-01'),
	('runner', 'run, left paw, right paw', '2023-12-10'),
    ('white', 'left paw, right paw', '2024-02-02'),
    ('gold', 'run', '2023-03-03'),
    ('black', 'eat', '2013-06-13');
    
INSERT INTO camels (animal_name,commands, date_of_birth) VALUES 
	('one', 'voice', '2020-08-01'),
	('two', 'voice, run', '2023-12-10'),
    ('grey', 'voice, sit', '2024-02-02'),
    ('brown', 'eat', '2023-03-03'),
    ('camel', 'eat', '2013-06-13');
    
INSERT INTO donkeys (animal_name,commands, date_of_birth) VALUES 
	('iaia', 'voice', '2020-08-01'),
	('donkey', 'voice, run', '2023-12-10'),
    ('osel', 'voice, sit', '2024-02-02'),
    ('ishak', 'eat', '2023-03-03'),
    ('oslik', 'eat', '2013-06-13');

/*
Задание 10. Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти 
в другой питомник на зимовку. 
Объединить таблицы лошади, и ослы в одну таблицу.
*/    
TRUNCATE camels;

INSERT INTO horses (animal_name, commands, date_of_birth)
SELECT animal_name, commands, date_of_birth
FROM donkeys;

DROP TABLE donkeys;

RENAME TABLE horses TO horses_donkeys;

CREATE TABLE young_animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE,
    age TEXT
);

/*
Задание 11. Создать новую таблицу «молодые животные»,
в которую попадут все животные старше 1 года, 
но младше 3 лет и в отдельном столбце, с точностью до месяца,
подсчитать возраст животных в новой таблице.
*/
DELIMITER $$
CREATE FUNCTION age_animals (date_b DATE)
RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE res TEXT DEFAULT '';
	SET res = CONCAT(
            TIMESTAMPDIFF(YEAR, date_b, CURDATE()),
            ' years ',
            TIMESTAMPDIFF(MONTH, date_b, CURDATE()) % 12,
            ' month'
        );
	RETURN res;
END $$
DELIMITER ;

INSERT INTO young_animals (animal_name, commands, date_of_birth, age)
SELECT animal_name, commands, date_of_birth, age_animals(date_of_birth)
FROM cats
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT animal_name, commands, date_of_birth, age_animals(date_of_birth)
FROM dogs
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT animal_name, commands, date_of_birth, age_animals(date_of_birth)
FROM hamsters
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT animal_name, commands, date_of_birth, age_animals(date_of_birth)
FROM horses_donkeys
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM cats
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3;

DELETE FROM dogs 
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3;

DELETE FROM hamsters 
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3;

DELETE FROM horses_donkeys 
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 3;

/*
Задание 12. Объединить все таблицы в одну, при этом сохраняя поля, 
указывающие на прошлую принадлежность к старым таблицам.
*/
CREATE TABLE animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE,
    age TEXT,
    animal_type ENUM('cat','dog','hamster', 'horse_donkey', 'young_animal') NOT NULL
);

INSERT INTO animals (animal_name, commands, date_of_birth, age, animal_type)
SELECT animal_name, commands, date_of_birth, age_animals(date_of_birth), 'cat'
FROM cats;

INSERT INTO animals (animal_name, commands, date_of_birth, age, animal_type)
SELECT animal_name, commands, date_of_birth, age_animals(date_of_birth), 'dog'
FROM dogs;

INSERT INTO animals (animal_name, commands, date_of_birth, age, animal_type)
SELECT animal_name, commands, date_of_birth, age_animals(date_of_birth), 'hamster'
FROM hamsters;

INSERT INTO animals (animal_name, commands, date_of_birth, age, animal_type)
SELECT animal_name, commands, date_of_birth, age_animals(date_of_birth), 'horse_donkey'
FROM horses_donkeys;

INSERT INTO animals (animal_name, commands, date_of_birth, age, animal_type)
SELECT animal_name, commands, date_of_birth, age_animals(date_of_birth), 'young_animal'
FROM young_animals;



