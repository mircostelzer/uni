package com.example.openfeign0A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OpenFeign0AApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeign0AApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(OpenFeign0AApplication.class);
    }

}
