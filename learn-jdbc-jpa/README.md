* Create a Spring Boot project with H2
    * dependencies
        * Spring Web
        * Spring Data
        * JDBC
        * Spring Data JPA
    * to run project - mvn spring-boot:run

* H2 Database
    * add to properties - spring.h2.console.enabled=true
    * add to properties - spring.datasource.url=jdbc:h2:mem:testdb
    * go to web - localhost:8080/h2-console
    * change JDBC URL to - jdbc:h2:mem:testdb - connect 
    * create schema.sql (with sql code) in resources folder
    * run spring and check for new table in h2 console 
