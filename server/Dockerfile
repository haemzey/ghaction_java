FROM maven:3.9-eclipse-temurin-22 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests 

FROM eclipse-temurin:22-jre AS runtime

WORKDIR /app

RUN groupadd \
    --system \
    --gid 1001 \
    appuser \
    && useradd \
    --system \
    --uid 1001 \
    --gid 1001 \
    --no-create-home \
    --shell /usr/sbin/nologin \
    appuser

COPY --from=builder /app/target/*.jar app.jar

RUN chown root:root app.jar \
    && chmod 0444 app.jar

EXPOSE 5000

USER appuser

CMD ["java", "-jar", "app.jar"]

