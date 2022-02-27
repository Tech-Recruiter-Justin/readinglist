FROM openjdk:17-slim
ENV JAVA_OPTS " -Xms512m -Xmx512m"
WORKDIR /root/server/booklist
COPY ../../../build/libs/readinglist-0.0.1-SNAPSHOT.jar ./
ENTRYPOINT ["java", "-jar", "readinglist-0.0.1-SNAPSHOT.jar"]