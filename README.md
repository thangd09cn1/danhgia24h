# DANHGIA24H-BACKEND
### Business Layer for DANHGIA24H Application
#### Overview

#### How to start?
* Pre-requisite: Java, MySql,Redis, Maven
* Create database named __danhgia24h__ in MySQL
* Config connection information in _src/main/resources/liquibase/liquibase.properties_
* Run this command to init the database: 
```
mvn liquibase:update
```

* Start application:
```
mvn spring-boot:run
```
The application runs at port 8090 by default.