FROM phusion/baseimage

ENV JAVA_HOME /usr/java/jdk1.8.0_112/

RUN mkdir -p /usr/java/

RUN curl \
  --silent \
  --location \
  --retry 3 \
  --header "Cookie: oraclelicense=accept-securebackup-cookie;" \
  "http://download.oracle.com/otn-pub/java/jdk/8u112-b15/jdk-8u112-linux-x64.tar.gz" \
    | gunzip \
    | tar x -C /usr/java/ \
    && ln -s $JAVA_HOME /usr/java/java \
    && rm -rf $JAVA_HOME/man

ENV PATH ${PATH}:${JAVA_HOME}/bin

COPY start_java.sh /

ADD config.yml /data/
ADD dropwizard-app-all.jar /data/

ENV JAVA_OPTIONS="-XX:+PrintGC "

CMD ["/start_java.sh", "-c", "-jar /data/dropwizard-app-all.jar server /data/config.yml"]

EXPOSE 8080
ENTRYPOINT ["/sbin/my_init", "--"]
