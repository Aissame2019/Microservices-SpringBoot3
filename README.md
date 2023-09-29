# Microservices Project with Spring Boot 3

This repository contains a microservices project built using Spring Boot 3. The project consists of two services: `department` and `employee`, which communicate with each other using HttpExchage. Additionally, the project includes the following components:

- **Department Service**: This microservice is responsible for managing department-related information.

- **Employee Service**: This microservice is responsible for managing employee-related information.

- **Config Server**: This service is responsible for managing configuration properties for all the microservices in the project. It allows for centralized configuration management.

- **Service Registry (Eureka)**: Eureka serves as a service registry and helps manage service discovery. It enables microservices to find and communicate with each other dynamically.

- **Trace Logger (Zipkin)**: Zipkin is used for distributed tracing. It tracks and logs requests as they flow through different microservices, providing insights into the performance and behavior of the system.