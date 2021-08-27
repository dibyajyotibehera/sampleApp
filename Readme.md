**Start App**

1.docker-compose -f ./src/main/docker/quickstart-postgres.yml up -d
2. ./gradlew clean build bootrun
3. swagger url - http://localhost:8080/swagger-ui/index.html
4. Format check - ./gradlew check 
5. Fix format issues - ./gradlew format
