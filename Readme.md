**Start App**

1.docker-compose -f ./src/main/docker/quickstart-postgres.yml up -d

2. ./gradlew clean build bootrun
3. swagger url - http://localhost:8080/swagger-ui/index.html?configUrl=/api-docs/swagger-config
4. Format/SAST(FIndbugs) check - ./gradlew check
6. dependency checker - ./gradlew dependencyCheckAnalyze

**Prereq**

1.Docker
2.Java 11

**TO-DO**

- logging (structured logging)(aop logging) (done - aspect4j/logback)
- error handling - controller advice
- Testing - (done - spring-boot-test,mockito,jacoco,arch-unit)
- base entity classes with audit fields (done)
- rest clients (Feign -- done)
- db integration & data migration (flyway - done) / pooling (done)
- profile properties
- code-base structure
- security config
- SAST check (done - org.owasp.dependencycheck/findbugs)
- healthcheck 
- Fault tolerance (Hystrix -- done)
- Distributed tracing system (done - spring cloud sleuth)
- Spring Cloud Config Server
- docker -docker compose
- api versioning (done)
- linting/code formatting  (done - checkstyle)
- swagger (done)
- authn
- authz
- filtering of index calls using Query DSL pattern?
- pagination of index calls
- pmd/cpd/checkstyle - Done (added Findbugs/Findsecbugs)
- CDCT
- pipeline-as-code
- docker image publish on green build
- docker image scanner
- dockerized local dev with hot-reload?
- Full-fledged `README.md` or `CONTRIBUTING.md` for new joiners to the codebase
- release pipeline?
- env-specific code
- talisman / hawkeye / https://github.com/Yelp/detect-secrets
- alerting/monitoring
