package com.clark.springpj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringPjApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPjApplication.class, args);
    }

}
