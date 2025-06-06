# Literalura
Literalura es una aplicacion de consola desarrollada con Java Spring Boot. Consiste en una biblioteca construida con datos de libros solicitados a una API externa y procesados para almacenarlos en una base de datos.

## Objetivo

Permitir al usuario listar, buscar y consultar libros desde una base de datos local, a partir de información obtenida de forma dinámica mediante una API pública.

## Como ejecutar la aplicacion

### Requisitos

- Java 17 o superior instalado
- PostgreSQL instalado y funcionando
- Maven instalado (`mvn -v` para verificar)

### 1. Clonar el repositorio
```bash
git clone https://github.com/SteveArtavia/literalura
cd literalura
```

### 2. Crear una base de datos en PostgreSQL
Abrí tu cliente de PostgreSQL (pgAdmin, psql, etc.) y ejecutá lo siguiente:

```SQL
CREATE DATABASE literalura;
CREATE USER tu_usuario WITH PASSWORD 'tu_contraseña';
GRANT ALL PRIVILEGES ON DATABASE literalura TO tu_usuario;
```
> También puedes usar el usuario postgres si lo prefieres.

### 3. Configurar la conexión en application.properties
Edita el archivo ubicado en:

```
src/main/resources/application.properties
```
Con el siguiente contenido:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Ejecutar la aplicacion

Desde la terminal, dentro del directorio del proyecto, ejecuta:
```bash
mvn spring-boot:run
```
Esto iniciará la aplicación, conectará con tu base de datos y mostrará el menú interactivo en consola.

## Funcionalidades
Menú de consola para interactuar con el usuario con las siguientes opciones:
  - Buscar libro por título
  - Mostrar libros registrados
  - Mostrar autores registrados
  - Mostrar autores vivos segun el año
  - Mostrar libros por idioma (ES, EN, FR, PT)
  - Salir del programa

## Integraciones y procesos
- **Consumo de API externa (Gutendex):** La aplicación realiza peticiones HTTP a la API pública Gutendex para obtener información sobre libros y autores.
- **Mapeo de datos con DTOs:** Los datos recibidos en formato JSON se convierten en objetos Java (DTOs) que representan la estructura necesaria para ser procesados dentro del sistema.
- **Procesamiento y persistencia con JPA (Hibernate):** Se utiliza Spring Data JPA para mapear los objetos Java a tablas en la base de datos PostgreSQL. Hibernate se encarga de generar y ejecutar automáticamente las consultas SQL.
- **Almacenamiento en PostgreSQL:** Una vez que los datos se procesan, se guardan en una base de datos local PostgreSQL utilizando Spring Data JPA (Hibernate), que se encarga de gestionar las entidades y generar las consultas SQL automáticamente.
- **Lógica de negocio:** La interacción del usuario con la app se maneja a través de clases `@Service`, que se encargan de procesar las solicitudes, consultar la base de datos, y devolver los resultados.

## Tecnologías usadas
- Java 21

- Spring Boot

- JPA (Hibernate)

- PostgreSQL

- Gutendex API

- Maven


  
