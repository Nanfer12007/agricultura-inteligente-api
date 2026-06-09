package com.fiap.agricultura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(
    scanBasePackages = "com.fiap.agricultura"
)
@EnableScheduling
public class AgriculturaApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                AgriculturaApplication.class,
                args);
    }
}