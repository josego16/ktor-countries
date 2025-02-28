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
CREATE TABLE User
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    dni      VARCHAR(20) UNIQUE NOT NULL,
    name     VARCHAR(100)       NOT NULL,
    phone    VARCHAR(15)        NOT NULL,
    username VARCHAR(100)       NOT NULL,
    password VARCHAR(255)       NOT NULL,
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