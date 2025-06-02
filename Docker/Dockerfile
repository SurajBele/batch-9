FROM centos:9
WORKDIR /opt/
ADD https://downloads.apache.org/tomcat/tomcat-9/v9.0.105/bin/apache-tomcat-9.0.105.tar.gz.asc /opt/
RUN yum install httpd -y
COPY index.html /var/www/html/index.html
CMD [ "systemctl start httpd" ]
