# How to run

**Open terminal/cmd in project root directory**

### Using docker

```
docker-compose up
```

### Running locally:

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

Eureka: **[http://localhost:8000](http://localhost:8000)** \
Swagger: **`http://<service-name>:<port>/swagger-ui/index.html`**
