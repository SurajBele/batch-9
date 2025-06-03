FROM alpine
ENV project=devops
WORKDIR /opt/
RUN yum install httpd -y
COPY index.html /var/www/html/index.html
EXPOSE 80
CMD [ "httpd -D FOREGROUND" ]


FROM alpine:latest

# Install Apache HTTP Server
RUN apk update && apk add --no-cache apache2

# Set environment variable
ENV project=devops

# Set working directory
WORKDIR /var/www/localhost/htdocs/

# Copy index.html to Apache's root directory
COPY index.html .

# Expose port 80
EXPOSE 80

# Start Apache in foreground
CMD ["/usr/sbin/httpd", "-D", "FOREGROUND"]