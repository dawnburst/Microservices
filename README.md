# Microservices
This project have 2 folders that contains 1 microservice each:

Folder exchangeProducer:
It is a Spring boot application that expose a rest API, that expect for currency transaction and pass it to RabbitMQ

Folder exchangeConsumer
It is a Spring boot application that listening to a RabbitMQ queue and get all the transaction that passed from the first app and calculate the data and insert it to MongoDB database
