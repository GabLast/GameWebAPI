# Archivo que representa la información para la creación de
# una imagen para Docker, indicando todos los parametros necesarios.

# Instalando Gradle para compilar al aplicación y luego lo necesario a una imagen completa.
FROM gradle:7.3.3-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar --no-daemon

# El comando FROM indica la imagen base. Usar imagenes ligeras
FROM openjdk:11.0.12-jre-slim-buster

# Quien mantiene la versión.
LABEL maintainer="Gabriel Marte <20170388@ce.pucmm.edu.do>"

# ENV spring.datasource.url='jdbc:mysql://192.168.77.10:3306/dbname'

# volumen para persisencia de datos con docker
VOLUME /playersData

# Puertos que estarán disponibles de nuestra aplicación.
EXPOSE 8080

# Copiando el archivo jar generado luego de la ejecución del comando
# gradle task bootjar, se crean el jar y se copia a la imagen.
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar

#Comando que se ejecuta una vez es iniciada la aplicación.
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
