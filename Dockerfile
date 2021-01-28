FROM rtfpessoa/ubuntu-jdk8
WORKDIR /usr/app
COPY ./target/Sender_progetto-0.0.1.jar ./
COPY docker_script/wait-for-it.sh ./
COPY docker_script/docker-entrypoint.sh ./
RUN chmod +x ./wait-for-it.sh ./docker-entrypoint.sh
ENTRYPOINT ["./docker-entrypoint.sh"]
CMD ["java","-jar","Sender_progetto-0.0.1.jar","-single"]