-- Crear tabla de Country
CREATE TABLE IF NOT EXISTS Country
(
    id            SERIAL PRIMARY KEY,
    pid           VARCHAR(20) UNIQUE NOT NULL,
    name          VARCHAR(100)       NOT NULL,
    country       VARCHAR(100)       NOT NULL,
    language      VARCHAR(100)       NOT NULL,
    hostedOlympic VARCHAR(100)       NOT NULL,
    activeSport   VARCHAR(100)       NOT NULL,
    flag_url      VARCHAR(255)
);

-- Crear tabla de User
CREATE TABLE IF NOT EXISTS `User`
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    token    VARCHAR(255)
);

-- Insertar datos en la tabla Country
INSERT INTO Country (pid, name, country, language, hostedOlympic, activeSport, flag_url)
VALUES ('FR01', 'France', 'France', 'French', 'Paris 2024', 'Football, Judo, Cycling, Swimming',
        'https://flagcdn.com/w320/fr.png'),
       ('EEUU02', 'United States', 'USA', 'English', 'Atlanta 1996, Salt Lake City 2002',
        'Basketball, Athletics, Swimming, Gymnastics', 'https://flagcdn.com/w320/us.png'),
       ('JP03', 'Japan', 'Japan', 'Japanese', 'Tokyo 2020, Nagano 1998', 'Judo, Table Tennis, Wrestling, Taekwondo',
        'https://flagcdn.com/w320/jp.png'),
       ('GR04', 'Germany', 'Germany', 'German', 'Munich 1972', 'Fencing, Rowing, Cycling, Handball',
        'https://flagcdn.com/w320/de.png'),
       ('BR05', 'Brazil', 'Brazil', 'Portuguese', 'Rio 2016', 'Football, Volleyball, Judo, Swimming',
        'https://flagcdn.com/w320/br.png'),
       ('KR06', 'South Korea', 'South Korea', 'Korean', 'Seoul 1988, Pyeongchang 2018',
        'Taekwondo, Archery, Shooting, Weightlifting', 'https://flagcdn.com/w320/kr.png'),
       ('CN07', 'China', 'China', 'Chinese', 'Beijing 2008, Beijing 2022',
        'Table Tennis, Weightlifting, Badminton, Shooting', 'https://flagcdn.com/w320/cn.png'),
       ('ES08', 'Spain', 'Spain', 'Spanish', 'Barcelona 1992', 'Football, Basketball, Tennis, Cycling',
        'https://flagcdn.com/w320/es.png'),
       ('CIS09', 'Russia', 'Russia', 'Russian', 'Sochi 2014', 'Wrestling, Weightlifting, Athletics, Shooting',
        'https://flagcdn.com/w320/ru.png'),
       ('IT10', 'Italy', 'Italy', 'Italian', 'Turin 2006, Milan Cortina 2026', 'Fencing, Rowing, Cycling, Athletics',
        'https://flagcdn.com/w320/it.png'),
       ('UK11', 'United Kingdom', 'United Kingdom', 'English', 'London 2012', 'Cycling, Athletics, Rowing, Boxing',
        'https://flagcdn.com/w320/gb.png'),
       ('AU02', 'Australia', 'Australia', 'English', 'Sydney 2000', 'Swimming, Cycling, Athletics, Rowing',
        'https://flagcdn.com/w320/au.png');

-- Insertar datos en la tabla User
INSERT INTO `User` (username, password, token)
VALUES ('josema', 'josema', ''),
       ('jaime', 'jaime', '');
-- Agregar clave foránea a la tabla User, si es necesario
-- Si deseas relacionar la tabla User con Country por ejemplo a través de un campo country_id:
-- ALTER TABLE "User" ADD COLUMN country_id INT;
-- ALTER TABLE "User" ADD CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES Country(id);