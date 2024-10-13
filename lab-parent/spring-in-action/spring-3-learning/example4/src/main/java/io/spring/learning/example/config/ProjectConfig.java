package io.spring.learning.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"io.spring.learning.example.implementation", "io.spring.learning" +
        ".example.services", "io.spring.learning.example.aspects"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
