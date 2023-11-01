#Базовый образ с Java 17
FROM openjdk:17-oracle

#Рабочая директория приложения
WORKDIR /app

#Копирование JAR-файла в контейнер
COPY build/libs/studentsmanager-0.0.1-SNAPSHOT.jar app.jar

#Запуск приложения
CMD ["java", "-jar", "app.jar"]