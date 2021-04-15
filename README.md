# How to Implement a Custom, Sequence-Based ID Generator in Spring Boot
This application generates id numbers in combination with 2 capital letters as prefix. and a separator. So it will generates id's with this format: XX_NNNNNN.

# application.properties file
Go to http://localhost:8080/h2-console/ to run the queries. To enable that just add that to the application properties file:
- spring.h2.console.enabled=true
- spring.datasource.url=jdbc:h2:mem:testdb
