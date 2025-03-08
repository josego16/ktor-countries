-- Crear base de datos si no existe
CREATE DATABASE IF NOT EXISTS dbCountries;
USE dbCountries;

-- Crear tabla User
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

-- Crear tabla Country sin la clave foránea inicialmente
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

-- Agregar la columna owner_id permitiendo valores NULL temporalmente
ALTER TABLE Country
    ADD COLUMN owner_id INT NULL;

-- Asignar un owner_id a los países existentes (se asigna al primer usuario disponible)
UPDATE Country
SET owner_id = (SELECT id FROM User ORDER BY id LIMIT 1);

-- Modificar la columna owner_id para que sea NOT NULL
ALTER TABLE Country
    MODIFY COLUMN owner_id INT NOT NULL;

-- Agregar la clave foránea con restricción ON DELETE CASCADE
ALTER TABLE Country
    ADD CONSTRAINT fk_country_user FOREIGN KEY (owner_id) REFERENCES User (id) ON DELETE CASCADE;

-- Insertar datos en la tabla Country con la nueva estructura
INSERT INTO Country (pid, name, capital, language, famousEvent, typicalGastronomy, flag_url, owner_id)
VALUES ('FR01', 'France', 'Paris', 'French', 'Tour de France', 'Baguette, Ratatouille, Croissant',
        'https://flagcdn.com/w320/fr.png', (SELECT id FROM User ORDER BY id LIMIT 1)),
       ('US02', 'United States', 'Washington D.C.', 'English', 'Super Bowl', 'Hamburger, Hot Dog, BBQ Ribs',
        'https://flagcdn.com/w320/us.png', (SELECT id FROM User ORDER BY id LIMIT 1)),
       ('JP03', 'Japan', 'Tokyo', 'Japanese', 'Cherry Blossom Festival', 'Sushi, Ramen, Tempura',
        'https://flagcdn.com/w320/jp.png', (SELECT id FROM User ORDER BY id LIMIT 1)),
       ('DE04', 'Germany', 'Berlin', 'German', 'Oktoberfest', 'Bratwurst, Pretzel, Schnitzel',
        'https://flagcdn.com/w320/de.png', (SELECT id FROM User ORDER BY id LIMIT 1)),
       ('BR05', 'Brazil', 'Brasilia', 'Portuguese', 'Carnival of Rio', 'Feijoada, Pão de Queijo, Açaí',
        'https://flagcdn.com/w320/br.png', (SELECT id FROM User ORDER BY id LIMIT 1)),
       ('KR06', 'South Korea', 'Seoul', 'Korean', 'Boryeong Mud Festival', 'Kimchi, Bibimbap, Bulgogi',
        'https://flagcdn.com/w320/kr.png', (SELECT id FROM User ORDER BY id LIMIT 1)),
       ('CN07', 'China', 'Beijing', 'Chinese', 'Chinese New Year', 'Peking Duck, Dim Sum, Hot Pot',
        'https://flagcdn.com/w320/cn.png', (SELECT id FROM User ORDER BY id LIMIT 1)),
       ('ES08', 'Spain', 'Madrid', 'Spanish', 'Running of the Bulls', 'Paella, Tapas, Jamón Ibérico',
        'https://flagcdn.com/w320/es.png', (SELECT id FROM User ORDER BY id LIMIT 1)),
       ('RU09', 'Russia', 'Moscow', 'Russian', 'Victory Day Parade', 'Borscht, Blini, Pelmeni',
        'https://flagcdn.com/w320/ru.png', (SELECT id FROM User ORDER BY id LIMIT 1)),
       ('IT10', 'Italy', 'Rome', 'Italian', 'Venice Carnival', 'Pizza, Pasta, Gelato',
        'https://flagcdn.com/w320/it.png', (SELECT id FROM User ORDER BY id LIMIT 1)),
       ('UK11', 'United Kingdom', 'London', 'English', 'Wimbledon', 'Fish and Chips, Full English Breakfast',
        'https://flagcdn.com/w320/gb.png', (SELECT id FROM User ORDER BY id LIMIT 1)),
       ('AU12', 'Australia', 'Canberra', 'English', 'Melbourne Cup', 'Vegemite, Meat Pie, Pavlova',
        'https://flagcdn.com/w320/au.png', (SELECT id FROM User ORDER BY id LIMIT 1));