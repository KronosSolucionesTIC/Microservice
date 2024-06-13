# Proyecto de Microservicios con Spring Boot

Este proyecto contiene dos microservicios que utilizan Maven, Spring Boot, JPA, JUnit, Mockito y Feign. El proyecto incluye scripts para configurar la base de datos y colecciones de Postman para probar los endpoints.

## Prerrequisitos

- Java 17
- Maven 3.9.7
- Un servidor de base de datos MySQL
- IntelliJ IDEA (recomendado) u otro editor de texto

## Configurarion de la base de datos

1. Clona el repositorio del proyecto en tu máquina local.
2. Navega a la carpeta `scripts` y encuentra el archivo `BaseDatos.sql`.
3. Ejecuta el script `BaseDatos.sql` en tu servidor de base de datos MySQL para crear las tablas necesarias.
4. Antes de ejecutar el proyecto, asegúrate de que los datos de conexión a MySQL en `application.properties` estén configurados correctamente.

## Configuración del Proyecto

1. Abre tu editor de texto preferido (recomendado IntelliJ IDEA).
2. Importa ambos microservicios como proyectos Maven.

## Importar como Proyecto Maven en IntelliJ IDEA

1. Abre IntelliJ IDEA.
2. Ve a File > Open y selecciona la carpeta del microservicio.
3. IntelliJ IDEA debería detectar automáticamente el proyecto Maven y empezar a importar las dependencias.

## Levantar los Microservicios

1. Navega a la raíz del primer microservicio en la terminal.

cd path/to/your/first/microservice

2. Usa Maven para compilar y ejecutar el microservicio.

mvn spring-boot:run

3. Repite los pasos anteriores para el segundo microservicio.

## Pruebas de Endpoints con Postman

1. Abre Postman.
2. Importa la colección de endpoints que se encuentra en la carpeta postman.
3. Importa la colección de environments que se encuentra en la misma carpeta postman.
4. Una vez importadas las colecciones, puedes empezar a probar los endpoints. La colección incluye ejemplos de peticiones para los diferentes endpoints: customer, account, movement, y el get del reporte.