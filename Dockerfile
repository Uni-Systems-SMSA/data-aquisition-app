

FROM maven:3.9.7-sapmachine-21
# for Java 21


WORKDIR /data-aquisition-app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run