package io.spring.learning.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = io.spring.learning.example.beans.Vehicle1.class)
public class ProjectConfigComponentScan {
}
