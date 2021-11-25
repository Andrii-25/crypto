# Spring Boot Cryptocurrency app

## How to install

### Using Git

1.  Clone the project from github. Change "myproject" to your project name.

```bash
https://github.com/Andrii-25/crypto.git ./myproject
```

### Using manual download ZIP

1.  Download repository
2.  Uncompress to your desired directory

### Go to the `resources/application.properties` file, and add the following content like it:
 ```
 spring.data.mongodb.host=localhost
 spring.data.mongodb.port=27017
 spring.data.mongodb.database=mydatabase* 
 spring.mvc.converters.preferred-json-mapper=gson
 ```
 

## Steps to run
1. Build the project using `mvn clean install`
2. Run using `java -jar target/crypto-0.0.1-SNAPSHOT.jar`
3. The web application is accessible via localhost:8080

## Alternatively, you can run the app without packaging it using:
`mvn spring-boot:run`

## Routes

### GET Routes

- /cryptocurrencies/minprice?name=[currency_name] - to get record with the lowest price of selected cryptocurrency (BTC, ETH or XRP).
- /cryptocurrencies/maxprice?name=[currency_name] - to get record with the highest price of selected cryptocurrency (BTC, ETH or XRP).
- /cryptocurrencies?name=[currency_name]&page=[page_number]&size=[page_size] - to get a selected page with selected number of elements.
- /cryptocurrencies/csv - to get generated CSV report.
