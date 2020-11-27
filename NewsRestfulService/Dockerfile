FROM java:8-jre
WORKDIR usr/src
ENV MONGO_DATABASE=newsdb
ENV MONGO_URI=mongodb://mongocontainer:27017/newsdb
ADD ./target/NewsRestfulService-0.0.1-SNAPSHOT.jar /usr/src/NewsRestfulService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongocontainer:27017/newsdb","-jar","NewsRestfulService-0.0.1-SNAPSHOT.jar"]