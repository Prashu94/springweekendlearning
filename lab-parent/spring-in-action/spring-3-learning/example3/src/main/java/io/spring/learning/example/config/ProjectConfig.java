package io.spring.learning.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"io.spring.learning.example.implementation", "io.spring.learning" +
        ".example.services"})
@ComponentScan(basePackageClasses = {io.spring.learning.example.beans.Vehicle.class,
        io.spring.learning.example.beans.Person.class})
public class ProjectConfig {
}
