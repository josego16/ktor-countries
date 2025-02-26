CREATE DATABASE IF NOT EXISTS dbCountries;

-- Crear tabla Country
CREATE TABLE Country
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    pid               VARCHAR(20) UNIQUE NOT NULL,
    name              VARCHAR(100)       NOT NULL,
    capital           VARCHAR(100)       NOT NULL,
    language          VARCHAR(100)       NOT NULL,
    famousEvent       VARCHAR(100)       NOT NULL,
    typicalGastronomy VARCHAR(255)       NOT NULL,
    flag_url          VARCHAR(255)       NULL
);

-- Crear tabla de User
CREATE TABLE IF NOT EXISTS `User`
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    dni      VARCHAR(20) UNIQUE NOT NULL,
    username VARCHAR(100)       NOT NULL,
    password VARCHAR(255)       NOT NULL,
    name     VARCHAR(100)       NOT NULL,
    phone    VARCHAR(15)        NOT NULL,
    token    VARCHAR(255)
);

-- Insertar datos en la tabla Country con la nueva estructura
INSERT INTO Country (pid, name, capital, language, famousEvent, typicalGastronomy, flag_url)
VALUES ('FR01', 'France', 'Paris', 'French', 'Tour de France', 'Baguette, Ratatouille, Croissant',
        'https://flagcdn.com/w320/fr.png'),
       ('US02', 'United States', 'Washington D.C.', 'English', 'Super Bowl', 'Hamburger, Hot Dog, BBQ Ribs',
        'https://flagcdn.com/w320/us.png'),
       ('JP03', 'Japan', 'Tokyo', 'Japanese', 'Cherry Blossom Festival', 'Sushi, Ramen, Tempura',
        'https://flagcdn.com/w320/jp.png'),
       ('DE04', 'Germany', 'Berlin', 'German', 'Oktoberfest', 'Bratwurst, Pretzel, Schnitzel',
        'https://flagcdn.com/w320/de.png'),
       ('BR05', 'Brazil', 'Brasilia', 'Portuguese', 'Carnival of Rio', 'Feijoada, Pão de Queijo, Açaí',
        'https://flagcdn.com/w320/br.png'),
       ('KR06', 'South Korea', 'Seoul', 'Korean', 'Boryeong Mud Festival', 'Kimchi, Bibimbap, Bulgogi',
        'https://flagcdn.com/w320/kr.png'),
       ('CN07', 'China', 'Beijing', 'Chinese', 'Chinese New Year', 'Peking Duck, Dim Sum, Hot Pot',
        'https://flagcdn.com/w320/cn.png'),
       ('ES08', 'Spain', 'Madrid', 'Spanish', 'Running of the Bulls', 'Paella, Tapas, Jamón Ibérico',
        'https://flagcdn.com/w320/es.png'),
       ('RU09', 'Russia', 'Moscow', 'Russian', 'Victory Day Parade', 'Borscht, Blini, Pelmeni',
        'https://flagcdn.com/w320/ru.png'),
       ('IT10', 'Italy', 'Rome', 'Italian', 'Venice Carnival', 'Pizza, Pasta, Gelato',
        'https://flagcdn.com/w320/it.png'),
       ('UK11', 'United Kingdom', 'London', 'English', 'Wimbledon', 'Fish and Chips, Full English Breakfast',
        'https://flagcdn.com/w320/gb.png'),
       ('AU12', 'Australia', 'Canberra', 'English', 'Melbourne Cup', 'Vegemite, Meat Pie, Pavlova',
        'https://flagcdn.com/w320/au.png');

-- Insertar datos en la tabla User con datos corregidos
INSERT INTO `User` (dni, username, password, name, phone, token)
VALUES ('12345678A', 'josema', 'hashed_password1', 'José Martínez', '654321789', NULL),
       ('87654321B', 'jaime', 'hashed_password2', 'Jaime López', '678912345', NULL);

-- Agregar clave foránea a la tabla User, si es necesario
-- Si deseas relacionar la tabla User con Country por ejemplo a través de un campo country_id:
-- ALTER TABLE "User" ADD COLUMN country_id INT;
-- ALTER TABLE "User" ADD CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES Country(id);