# Imagem base com Java 21
FROM eclipse-temurin:21-jre

# Diretório de trabalho
WORKDIR /app

# Copia o JAR
COPY target/*.jar app.jar

# Expõe a porta interna
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]

