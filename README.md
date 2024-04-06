# Spring Boot RabbitMQ Integration

This project demonstrates integrating RabbitMQ with a Spring Boot application, including creating queues, exchanges, bindings, producers, and consumers. It showcases the exchange of string and JSON messages between producers and consumers using RabbitMQ as the broker.

## Requirements

- Java 8 or higher
- Maven
- RabbitMQ Server

## Setup

1. **Clone the repository:**
```bash
git clone [https://github.com/sudip777/rabbitmq-demo.git](https://github.com/sudip777/rabbitmq-demo.git)
```

2. **Configure RabbitMQ:**
 - Setting Up RabbitMQ using Docker: Install docker desktop and open it

  ```bash Setting Up RabbitMQ using Docker
docker pull rabbitmq:3.13.1-management 
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.13.1-management 
```
  
- Update the RabbitMQ connection details in application.properties if needed.

3. **Build the project:**
   ```bash
   cd demorabbitmq
   mvn clean install
   ```
4. **Run the application:**
      ```bash
      mvn spring-boot:run
      ```
## Usage

### Sending String Messages
You can send string `messages` to RabbitMQ by making a GET request to `/api/v1/publish` endpoint with the message parameter.
#### Example
```bash
curl -X GET "http://localhost:8080/api/v1/publish?message=Hello%20RabbitMQ"
```


### Sending Json Messages
You can send JSON messages to RabbitMQ by making a POST request to `/api/v1/publish` endpoint with a JSON payload representing the User object.
#### Example
```bash
curl -X POST \
  http://localhost:8080/api/v1/publish \
  -H 'Content-Type: application/json' \
  -d '{
        "id": 1,
        "firstName": "John",
        "lastName": "Doe"
      }'
```

### Consuming Messages
The configured RabbitMQ consumers consume messages. The string messages are consumed by `RabbitMQConsumer` and JSON messages by `RabbitMQJsonConsumer`.

## Configuration
You can customize the RabbitMQ connection details and queue/exchange configurations in `application.properties`.

## Dependencies
- Spring Boot
- Spring AMQP
- Jackson (for JSON serialization/deserialization)






