package com.stockBroker.userService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.stockBroker.userService")
public class UserServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
