FROM ubuntu:18.04

# Add repo
RUN apt update
RUN apt install curl -y
RUN apt install gnupg2 -y

RUN curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add -
RUN curl -sL https://deb.nodesource.com/setup_10.x | bash
RUN echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list

# Update
RUN apt update

# Install
RUN apt install git -y
RUN apt install maven -y

# Show versions
RUN mvn -version

RUN git clone https://github.com/lirugo/barbershopMrWhite.git
WORKDIR barbershopMrWhite

# Build jar
RUN mvn clean install

CMD ls && nohup mvn spring-boot:run -e