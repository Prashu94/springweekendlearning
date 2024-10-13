package io.spring.learning.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.spring.learning.example.beans")
public class ProjectConfig {
}
