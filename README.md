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

![alt text](https://github.com/MattMendez/UserRegistration-Nisum/blob/master/image.jpg)


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
