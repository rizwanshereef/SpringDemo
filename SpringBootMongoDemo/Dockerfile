FROM java:8-jre
WORKDIR usr/src/
ENV MONGO_DATABASE=policydb
ENV MONGO_URI=mongodb://mongocontainer:2701/policydb
ADD <path_jar> eg: ./target/SpringBootMongoDemo-0.0.1-SNAPSHOT.jar /usr/src/SpringBootMongoDemo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongocontainer:2701/policydb","-jar","SpringBootMongoDemo-0.0.1-SNAPSHOT.jar"]