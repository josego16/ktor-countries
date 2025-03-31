# Proyecto Ktor Countries

## Descripción del Proyecto

Este proyecto es una aplicación basada en Ktor que proporciona una API para gestionar países y usuarios. Incluye características para agregar, actualizar, eliminar y recuperar países y usuarios. El proyecto utiliza una base de datos MariaDB para la persistencia y JWT para la autenticación.

## Características

- Agregar, actualizar, eliminar y recuperar países
- Agregar, actualizar, eliminar y recuperar usuarios
- Autenticación basada en JWT
- Integración con base de datos MariaDB
- Servir archivos estáticos

## Tecnologías Utilizadas

- Kotlin
- Ktor
- MariaDB
- JWT
- Exposed (biblioteca SQL)
- Bcrypt (para el hash de contraseñas)
- Logback (para el registro de logs)

## Rutas de la API

### Rutas de País

- `GET /country`: Recuperar todos los países
- `GET /country/{pid}`: Recuperar un país por su PID
- `GET /country/language/{language}`: Recuperar países por idioma
- `POST /country`: Agregar un nuevo país
- `PATCH /country/{pid}`: Actualizar un país por su PID
- `DELETE /country/{pid}`: Eliminar un país por su PID

### Rutas de Usuario

- `GET /user`: Recuperar todos los usuarios
- `GET /user/{dni}`: Recuperar un usuario por su DNI
- `POST /user/login`: Iniciar sesión de un usuario
- `POST /user/register`: Registrar un nuevo usuario

### Ejemplos de Solicitudes para Postman

#### Rutas de País

- Recuperar todos los países:
  ```
  GET /country
  Authorization: Bearer <JWT_TOKEN>
  ```

- Recuperar un país por su PID:
  ```
  GET /country/{pid}
  Authorization: Bearer <JWT_TOKEN>
  ```

- Recuperar países por idioma:
  ```
  GET /country/language/{language}
  Authorization: Bearer <JWT_TOKEN>
  ```

- Agregar un nuevo país:
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

- Actualizar un país por su PID:
  ```
  PATCH /country/{pid}
  Authorization: Bearer <JWT_TOKEN>
  Content-Type: application/json
  Body: {
    "name": "new_country_name",
    "language": "new_country_language"
  }
  ```

- Eliminar un país por su PID:
  ```
  DELETE /country/{pid}
  Authorization: Bearer <JWT_TOKEN>
  ```

#### Rutas de Usuario

- Recuperar todos los usuarios:
  ```
  GET /user
  ```

- Recuperar un usuario por su DNI:
  ```
  GET /user/{dni}
  ```

- Iniciar sesión de un usuario:
  ```
  POST /user/login
  Content-Type: application/json
  Body: {
    "dni": "user_dni",
    "password": "user_password"
  }
  ```

- Registrar un nuevo usuario:
  ```
  POST /user/register
  Content-Type: application/json
  Body: {
    "dni": "user_dni",
    "password": "user_password",
    "name": "user_name"
  }
  ```
