package com.pup.taguig.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan; // Make sure this is imported

@SpringBootApplication
@MapperScan("com.pup.taguig.app.mapper") // ADD THIS LINE!
public class OrderingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderingSystemApplication.class, args);
    }
}