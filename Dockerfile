# Stage 1: Build your Java application
FROM docker.io/maven:3.8.5 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
COPY settings.xml /usr/share/maven/conf/settings.xml
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

RUN ls -l /usr/src/app/target/
# Stage 2: Runtime Environment

FROM library/eclipse-temurin:17.0.9_9-jdk

RUN apt-get update && \
    apt-get install -y telnet iputils-ping && \
    rm -rf /var/lib/apt/lists/*
    
# Configurando o fuso horário (por exemplo, para São Paulo)
ENV TZ=America/Sao_Paulo

RUN \
  addgroup --gid 3000 rest-outbound-group \
  && adduser --disabled-password --gecos "" --ingroup rest-outbound-group --uid 1000 rest-outbound-user

# Copy Your Application and Scripts
COPY --from=build /usr/src/app/target/*.jar /usr/local/rest-outbound/
COPY --from=build /usr/src/app/src/main/docker/startup.sh startup.sh
RUN chmod +x startup.sh

# Expose Port and Define Startup Command
EXPOSE 8080
CMD ["./startup.sh"] 
