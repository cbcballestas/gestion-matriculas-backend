# Gestión matrículas BACKEND
Backend para gestión de matrículas usando: Spring Boot 3, Spring Security, JWT y PostgreSQL como motor 
de base de datos.

## Requirements
- [JDK 17](https://adoptium.net/es/?variant=openjdk17)
- [Maven 3](https://maven.apache.org/)
- PostgreSQL

You will need to set up your database (or create your own) with the following configuration
``` yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost/db_evaluacion_final
    username: postgres
    password: 
    driver-class-name: org.postgresql.Driver

  jpa:
    show-sql: false
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
  mvc:
    throw-exception-if-no-handler-found: true
    static-path-pattern: /templates

jwt:
  secret: jwt_secret
```

## Run application

There are several ways to run a Spring Boot application in your local machine. The most common way is executing `main` method in `com.cballestas.evaluacionfinal.EvaluacionFinalApplication` class from your IDE

Alternative you can use [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle), just running:

```shell
mvn spring-boot:run
```

## Endpoints 
- Login (para obtener JWT)
  - http://localhost:8080/login 
  
  ```json
    {
      "username": "mito",
      "password": "123456"
    }
  ```
- CRUD Cursos
  - http://localhost:8080/api/v1/courses 
- CRUD Estudiantes
  - http://localhost:8080/api/v1/students 
- Listado de estudiantes ordenados por edad (de forma descendente)
  - http://localhost:8080/api/v1/students/age-desc
- Relación de cursos matriculados y sus estudiantes correspondientes
  - http://localhost:8080/api/v1/students/summary