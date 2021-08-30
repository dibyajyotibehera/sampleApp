**Start App**

1.docker-compose -f ./src/main/docker/quickstart-postgres.yml up -d

2. ./gradlew clean build bootrun
3. swagger url - http://localhost:8080/swagger-ui/index.html?configUrl=/api-docs/swagger-config
4. Format check - ./gradlew check 
5. Fix format issues - ./gradlew format
6. SAST check - ./gradlew dependencyCheckAnalyze

**Prereq**

1.Docker
2.Java 11

**TO-DO**

- logging (structured logging)(aop logging)
- error handling - controller advice
- base entity classes with audit fields (done)
- rest clients
- db integration & data migration (flyway) / cache config / pooling (done)
- profile properties
- code base structure
- security config
- SAST check
- health check 
- Fault tolerance (resilience4j)
- Distributed tracing system
- Spring Cloud Config Server
- docker -docker compose
- api versioning  ( done)
- linting/code formatting  (done - spring java format)
- code cov 
- swagger (done)

