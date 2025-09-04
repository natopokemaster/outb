FROM library/eclipse-temurin:21.0.2_13-jdk

LABEL author="Gabriel Joioso"
LABEL email="g.eduardojoioso2@dxc.com"
LABEL company="Claro BR"
LABEL version="1.0.0.RELEASE"

RUN \
  addgroup --gid 3000 serviceusagesbroadbandsv1group \
  && adduser --disabled-password --gecos "" --ingroup serviceusagesbroadbandsv1group --uid 1000 serviceusagesbroadbandsv1-user

USER serviceusagesbroadbandsv1-user
WORKDIR /home/serviceusagesbroadbandsv1-user

COPY --chown=serviceusagesbroadbandsv1-user:serviceusagesbroadbandsv1group target/serviceusagesbroadbands /home/serviceusagesbroadbandsv1-user/serviceusagesbroadbands


EXPOSE 8080


CMD ["./serviceusagesbroadbands", "--spring.config.location=file:/home/serviceusagesbroadbandsv1-user/configs/,classpath:/"]



