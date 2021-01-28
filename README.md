# Sender role of blockchain system - Spring boot + RabbitMQ + Docker
blockchain simulation sender
## Getting Started
These instructions help you to start sender role of blockchain.

### Prerequisities
In order to run this project you'll need: 

**docker** (OPTIONAL) 

* [Windows](https://docs.docker.com/windows/started).
* [OS X](https://docs.docker.com/mac/started/).
* [Linux](https://docs.docker.com/linux/started/).

**JAVA**

* [JAVA](https://www.java.com/it/download/).

**Receiver_rabbitmq**

* [LINK](https://github.com/simone1040/Receiver_rabbitmq) Receiver part of blockchain.


### Usage

Sender can work in two ways:
* -single send only one product to message queue.
* -polling send a product every two seconds to message queue

In order to run this exaple project:
* you must update **/src/main/resources/sender.conf** with the address where you install rabbitmq-management.

* run **mvn clean package** in the root of project.

# FIRST MODE

  * **docker build -t sender** in the root of project in order to create image of sender role.in Dockerfile you can change -single to -polling(OPTIONAL).

  * **docker compose up -d** in the root of project in order to run this example(OPTIONAL). 

  * for running sender application you must have started Receiver_rabbitMQ.
 
# SECOND MODE
 * **java -jar target/#NAME_JAR.jar --[single/polling]
