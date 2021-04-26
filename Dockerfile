FROM tomcat:latest

COPY /target/web.war /usr/local/tomcat/webapps/web.war

WORKDIR /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
