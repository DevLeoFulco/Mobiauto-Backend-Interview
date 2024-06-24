# Usar a imagem base do OpenJDK 17
FROM openjdk:17-jdk-alpine

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo jar gerado para o contêiner
COPY target/mobiauto-0.0.1-SNAPSHOT.jar app.jar

# Definir o comando padrão para executar quando o contêiner iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]
