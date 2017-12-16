FROM registry.docker-cn.com/library/java:alpine
MAINTAINER david.du
EXPOSE 8080
COPY community.jar /var/lib/shanshui/community/community.jar
CMD java -jar /var/lib/shanshui/community/community.jar --spring.profiles.active=test