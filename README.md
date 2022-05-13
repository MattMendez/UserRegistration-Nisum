# Prueba Técnica NISUM - Evaluación: JAVA.
### Autor: Matias Solana Mendez

### Tecnologías

- [JDK 11](https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- [Git](https://git-scm.com)
- Spring Boot
- JPA
- Hibernate
- H2
- Maven
- Autenticación con Token JWT
- Pruebas Unitarias con Junit

### Funcionalidades

1. Crear Usuario

2. Validación y restricción si el correo a registrar ya existe

3. Validación y restricción expresión regular para registro de correos (test@dominio.com)

4. Validación y restricción expresión regular en la contraseña para validar formato correcto, también customizable a traves
de la propiedad ```user.password.regex=${user.password.regex}``` como variable de entorno durante un despliegue

6. Persistencia del token junto a la información del Usuario

7. Formato en los mensajes: {"mensaje": "mensaje de error"}

8. Pruebas unitarias con junit

### Diagrama de la solución

![alt text](https://github.com/[MattMendez]/[UserRegistration-Nisum]/blob/[master]/image.jpg?raw=true)

![alt text](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Untitled%20Diagram.drawio#R7VvJcts4EP2WOahq5qAUd8pHy1uSyaSS2B6PjxAJSRhDBANCW74%2BDRHcQGqxZMqO40tMAK0G0P3wuhtkOvbZZHHFUTz%2Bh4WYdiwjXHTs845lmXbPhD%2ByZ5n2%2BJ6Tdow4CZVQ0XFNfmDVaajeKQlxUhEUjFFB4mpnwKIIB6LShzhn86rYkNHqrDEa4VrHdYBovfeOhGKc9vYsv%2Bh%2Fj8lonM1seifpyARlwmonyRiFbF7qsi869hlnTKRPk8UZptJ4mV3uPizv6KcH7%2Brj1%2BQ7uu3%2FffP5326q7PIxP8m3wHEknla1laqeITpV9lJ7FcvMgJxNoxBLJUbH7o%2FFhMKjCY%2F%2FYyGWyuFoKhh0MS7GbMQiRD8xFiu5IYuEEjNlG0fhqXQstAeUBQ9p1yWhVM0BLSXfg1YiOHvIfScV5I6QwhQNMO2j4GG0WugZo4zDUMQiLFWFAAa1l2JxF0Vvf0fbKh8kbMoDvEHOVhBHfIQ36fNSObm%2BEk6V564wm2DBlyDAMUWCzKpgRupMjHK5wu%2FwoFz%2FCBjYNRjcJph3LA9NwIv9aJDEK1MZZ%2BBLziiVg2txIn00HxOBr2O0MtYcqKWKnTImYNv9EUVJojy6xeGPc9gMc4EXG02cjXrqnCui66nmvGANM6OCcYkxHKMlpzg1p3xmb6fzoNPp7Xg6s%2BC19XgqrGS42Pm0Kk1fGIF9FSJsOExgYTpy8gn3B5NbA9M9RGUdTdsd8kvj7ZnQ5D8OTOaLB5O3JlwYiHKMQrkXvCAJ2OSyTlhjNhlMk%2B0houJXiZpLNCFU2ug9pjMsSIAaAgmiZBRBIwAXw5IaAQNTkmgELa9o3awACpzbYoDxqwEmb5cjjNEQYXptRRi%2F5seLRYBjQVikxXqPwlr6A%2Fk0kk%2FfsJhyKeRkC35FmYB9UnVUHuKfLRU42SUVeOXkDU7my%2F9yvdC4l413btY8X5QHz5d7oWQr6Wfs%2FOuwfiGj8O1YVXzbtobbdG%2FqVweFD%2BO0%2F4F%2Fv%2F2wvLnyz2Zf%2FShwllnReQB0G8HZAOISxAv4FIi5rwBmE3w0L7aMp0arPWuBmK2yHComiNDVxc0kpulKRsCvb%2FF%2BXby3To4Y7xshdPJ28Epy2W3k1oNnNLt5X6ZW8LA0FnZ1tz8dC2%2Fcf%2BlIf5zL9d0Kea7XZnw3cLyi15fzabc%2Frn3EnK8RdnXG3WB0YwejQ1bWWA%2FXjLSrfdczn6lVOl7dmHnCUzam3Rr12c9LfY9LWaF4FiXGhNZ9phGeix%2FJRgt0uT792OXq7NA8ZUe2NHdjy7oit6rI0SGXWqKmCOoctCyJxVIgWb9g22yeZ926dHnXrcjDQ7qCJ83E6yHgCzDxnPHw9SR2LdCbltjldyDPltjt9Krgt7kfqOaZ5hayPZA4d7sHeAllv%2BUb7wzDsXqub8p%2Fe1UQOzCaj%2Fmm7e5Ei3Ue0y%2FPvNbS2sajsNuLDmAEUYV4jW8kbwA10VM1MCFhmJ4SnJAfaLBSJQGkIgHodfsd91zqgiOSqGOQw1qD6xHTMUsLLXbDxbPTQFdWW3RVf3%2Fw5iM9LWm4LDiqj%2BrvBtQ7nmvMZwRC%2FW%2FtLlNLR5ve5fSO6a6GC7qbMTjJmKZeC5Cs3QeyJ0EziPF7p3PHtLLvVnPihm8ymqzcWp6V3ZkcuYzcoxx8AbduG3G6%2FdbNaYbGoXWkWYWUf7JvHakFVV8%2F2k9UR9YWbG6uI7fIt1RHWjX2yW4QoSyLKifG%2Bz6VX0z2g5RDTqVPR4M%2FYZUwt5H9%2BWuFRUMWFN2hqhelaLlkzMbTuCBHTStelAfSSeVIxPgE0dLYDHGC4C%2BEIiSmXH6iulEuQPE6kbmiHjkoa8HVCIUjjXk3r1H1XzIej1GkVFppnwyhXRU1ZXceOLMxAkQSqZmMbKurEcFB2RD0ZzMpYpZUufqGtjSNrO%2BrC8t1wV4GDwTUSZ1pkO0qsq3IDfIqrKv50XJ6qQshhVEPbubNldYQB4wj%2BY1BV4xJ8BDhRC2PRESQzD66bMmXG%2BVKy6nIDSlDQjdOSJKYomUmTkkkA%2BQfZBIDTSNp6X4B2OwmfJWrpuCGw5LiOx1ZlxNtiait5ZRakuI1hE%2B3IXzqr4OfLnzWvzP9%2Fe4pDoqwL%2BIewXUr9wi%2BU0WZVb1I2PMewdEKolpStyZQPza%2Buloc96zN8VWXd7xjxNf6BV%2F%2BPu4bTmIWJZK4rGf%2FGKuFGsDV8pkWX8xBs%2FjvHKnviv8UY1%2F8BA%3D%3D)

#### Ejecución con maven y Java (Necesario maven y java 11 instalados)

- clonar el proyecto ```$ git clone https://github.com/bisberrios/nisum.git```
- Ir al directorio del proyecto
  ```$ cd nisum/ ```
- Generar jar del proyecto

```$ mvn clean && mvn install -DskipTests  -Dspring.profiles.active=local```
- Correr proyecto con Maven ```$ mvn spring-boot:run  ```


## Documentacion
Para pruebas y documentacion recomiendo usar [Swagger](https://swagger.io) una vez que el proyecto este corriendo se puede acceder por el siguiente link:
[Swagger-UI](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/)