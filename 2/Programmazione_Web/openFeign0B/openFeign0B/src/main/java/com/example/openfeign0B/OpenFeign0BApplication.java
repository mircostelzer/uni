package com.example.openfeign0B;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OpenFeign0BApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeign0BApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(OpenFeign0BApplication.class);
    }
}
