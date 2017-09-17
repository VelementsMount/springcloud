FROM java:8u111-jdk
RUN echo "Asia/Shanghai" > /etc/timezone
WORKDIR /var/workspace
EXPOSE 8080
ADD build/libs/eureka-client.jar /var/workspace
ADD docker.sh /var/workspace
ENTRYPOINT ["/bin/bash","docker.sh","eureka-client"]