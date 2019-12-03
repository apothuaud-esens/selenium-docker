FROM markhobson/maven-chrome

WORKDIR /usr/app

COPY . /usr/app

RUN ["mvn", "clean", "install", "-DskipTests=true"]

RUN ["sh", "entrypoint.sh"]