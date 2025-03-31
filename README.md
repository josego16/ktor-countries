# Ktor Countries Project

## Project Overview

This project is a Ktor-based application that provides an API for managing countries and users. It includes features for adding, updating, deleting, and retrieving countries and users. The project uses a MariaDB database for persistence and JWT for authentication.

## Features

- Add, update, delete, and retrieve countries
- Add, update, delete, and retrieve users
- JWT-based authentication
- Database integration with MariaDB
- Static file serving

## Technologies Used

- Kotlin
- Ktor
- MariaDB
- JWT
- Exposed (SQL library)
- Bcrypt (for password hashing)
- Logback (for logging)

## API Routes

### Country Routes

- `GET /country`: Retrieve all countries
- `GET /country/{pid}`: Retrieve a country by its PID
- `GET /country/language/{language}`: Retrieve countries by language
- `POST /country`: Add a new country
- `PATCH /country/{pid}`: Update a country by its PID
- `DELETE /country/{pid}`: Delete a country by its PID

### User Routes

- `GET /user`: Retrieve all users
- `GET /user/{dni}`: Retrieve a user by their DNI
- `POST /user/login`: Login a user
- `POST /user/register`: Register a new user

### Example Requests for Postman

#### Country Routes

- Retrieve all countries:
  ```
  GET /country
  Authorization: Bearer <JWT_TOKEN>
  ```

- Retrieve a country by its PID:
  ```
  GET /country/{pid}
  Authorization: Bearer <JWT_TOKEN>
  ```

- Retrieve countries by language:
  ```
  GET /country/language/{language}
  Authorization: Bearer <JWT_TOKEN>
  ```

- Add a new country:
  ```
  POST /country
  Authorization: Bearer <JWT_TOKEN>
  Content-Type: application/json
  Body: {
    "pid": "country_pid",
    "name": "country_name",
    "language": "country_language"
  }
  ```

- Update a country by its PID:
  ```
  PATCH /country/{pid}
  Authorization: Bearer <JWT_TOKEN>
  Content-Type: application/json
  Body: {
    "name": "new_country_name",
    "language": "new_country_language"
  }
  ```

- Delete a country by its PID:
  ```
  DELETE /country/{pid}
  Authorization: Bearer <JWT_TOKEN>
  ```

#### User Routes

- Retrieve all users:
  ```
  GET /user
  ```

- Retrieve a user by their DNI:
  ```
  GET /user/{dni}
  ```

- Login a user:
  ```
  POST /user/login
  Content-Type: application/json
  Body: {
    "dni": "user_dni",
    "password": "user_password"
  }
  ```

- Register a new user:
  ```
  POST /user/register
  Content-Type: application/json
  Body: {
    "dni": "user_dni",
    "password": "user_password",
    "name": "user_name"
  }
  ```
