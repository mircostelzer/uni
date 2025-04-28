package com.example.openfeign0B;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.openfeign0B")
public class ProjectConfig {
}
