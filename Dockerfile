FROM gradle:latest AS BUILD
WORKDIR /usr/app/
COPY . . 
RUN gradle build

# Package stage

FROM openjdk:17
ENV JAR_NAME=*.jar
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
EXPOSE 8080
RUN ls -l $APP_HOME/build/libs/
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME