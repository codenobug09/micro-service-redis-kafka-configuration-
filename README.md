# Microservices Demo - Bundle (skeleton)

This archive contains a runnable skeleton for:
- Eureka Server
- API Gateway (Spring Cloud Gateway)
- Product Service (uses MySQL + Redis cache)
- Order Service (Feign + Kafka producer + same MySQL schema)

Infra: MySQL, Redis, Zookeeper, Kafka are provided via docker-compose.

## Quick start

1. Start infra:
```bash
docker-compose up -d
```

2. Build and run services (in separate terminals):
```bash
cd eureka-server
mvn -q -DskipTests package
mvn -q spring-boot:run

cd ../product-service
mvn -q -DskipTests package
mvn -q spring-boot:run

cd ../order-service
mvn -q -DskipTests package
mvn -q spring-boot:run

cd ../api-gateway
mvn -q -DskipTests package
mvn -q spring-boot:run
```

3. Create a product:
```bash
curl -X POST http://localhost:8081/api/products -H "Content-Type: application/json" -d '{"name":"Laptop Dell XPS","price":25000}'
```

4. Create order via gateway:
```bash
curl -X POST http://localhost:8080/order-service/api/orders/create/1
```

Eureka UI: http://localhost:8761

Notes:
- This is a minimal skeleton intended for local testing and demonstration.
- The services target Spring Boot 2.7 and Spring Cloud 2021.x for compatibility.
