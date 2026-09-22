# ---------- Etapa 1: build da aplicação com Maven ----------
FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app

# Copia primeiro só o pom.xml para aproveitar cache de dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Agora copia o código-fonte e builda o .jar (pulando os testes para deploy mais rápido)
COPY src ./src
RUN mvn clean package -DskipTests

# ---------- Etapa 2: imagem final, só com o necessário pra rodar ----------
FROM eclipse-temurin:25-jre
WORKDIR /app

COPY --from=build /app/target/pingado-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
