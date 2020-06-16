FROM tomcat:latest
RUN rm -rf /usr/local/tomcat/webapps/*
ADD target/Webapp01.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 9090
CMD ["catalina.sh", "run"]