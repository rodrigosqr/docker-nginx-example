FROM nginx:latest
MAINTAINER Rodrigo Siqueira <rodrigosiqueira.01@gmail.com>
# COPY /public /var/www/public
COPY /docker/config/nginx.conf /etc/nginx/nginx.conf
# RUN chmod 755 -R /var/www/public
EXPOSE 80 443
ENTRYPOINT ["nginx"]
# Parametros extras para o entrypoint
CMD ["-g", "daemon off;"]