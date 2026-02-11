# Stage 1: Build ứng dụng bằng Maven
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Lệnh này sẽ build ra file .jar và bỏ qua bước chạy test để tiết kiệm thời gian
RUN mvn clean package -DskipTests

# Stage 2: Chạy ứng dụng bằng JDK rút gọn
FROM eclipse-temurin:21-jre
WORKDIR /app
# Copy file .jar từ Stage 1 sang Stage 2
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]