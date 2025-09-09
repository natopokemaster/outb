FROM azul/zulu-openjdk-alpine:11-jre

LABEL author="Carmem Pereira"
LABEL email="carmem.pereira@dxc.com"
LABEL company="Claro BR"
# same version in jar file 
LABEL version="1.0.0.RELEASE" 

RUN \
  addgroup -g 3000 contract-prospect-service-group \
  && adduser -D -g '' -G contract-prospect-service-group -u 1000 contract-prospect-service-user \
  && apk update \
  && apk add openssl 'busybox>=1.33.1-r6'

USER contract-prospect-service-user

WORKDIR /home/contract-prospect-service-user

COPY --chown=contract-prospect-service-user:contract-prospect-service-group target/contract-prospect-service-1.0.0.RELEASE.jar /home/contract-prospect-service-user

EXPOSE 8081

ENTRYPOINT ["/usr/bin/java", "-jar"]

CMD ["contract-prospect-service-1.0.0.RELEASE.jar"]
