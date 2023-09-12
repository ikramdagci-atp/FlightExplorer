package com.ikramdagci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@EnableTransactionManagement
public class FlightSearchApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightSearchApiApplication.class, args);
    }

}
