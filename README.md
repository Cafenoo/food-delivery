# How to run

#### Open terminal/cmd in project root directory

### Using docker

```
docker-compose up
```

### Running locally

#### Prerequisites
- Gradle 8.5
- Java 17

You still need docker 
```
docker-compose up -d customer-service-database restaurant-service-database delivery-service-database order-service-database 
```

```
gradle fd-discovery-service:bootRun 
gradle fd-customer-service:bootRun 
gradle fd-restaurant-service:bootRun 
gradle fd-delivery-service:bootRun 
gradle fd-order-service:bootRun
```

### Common URLs

Discovery Service - Eureka: **[http://localhost:8000](http://localhost:8000)** \
Customer Service: **[http://localhost:8001](http://localhost:8001)** \
Restaurant Service: **[http://localhost:8002](http://localhost:8002)** \
Delivery Service: **[http://localhost:8003](http://localhost:8003)** \
Order Service: **[http://localhost:8004](http://localhost:8004)** 

Swagger: **`http://<service-name>:<port>/swagger-ui/index.html`**
