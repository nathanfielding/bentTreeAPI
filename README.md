# Bent Tree API
This is a work-in-progress project I am writing to learn the basic concepts of Spring, Spring Boot, and Spring Data.
My goal for this project is to build a RESTful API that allows for the workers in the leasing office to quickly access specific data about the apartments, tenants, and leases along with the relationships between them to provide accurate information anyone who needs it.

# System Requirements
1. Java JDK 17 or higher
2. Docker (for Postresql DB Container)

# Running the Project
```
docker compose up -d
./mvnw spring-boot:run
```

# Endpoints to Query (GET)
* All apartments: http://localhost:8080/api/apartments
    - by apartment number: number/{number}
* All tenants: http://localhost:8080/api/tenants
    - by tenant name: name/{name}
    - by tenant apartment number: /apartment/{number}

# Endpoints to Create (POST)
* http://localhost:8080/api/apartments
* http://localhost:8080/api/tenants