package io.spring.learning.example;

import io.spring.learning.example.beans.Person;
import io.spring.learning.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example3_3Application {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("Before retrieving the Person bean from the Spring Context");
        Person person = context.getBean(Person.class);
        System.out.println("After retrieving the Person bean from the Spring Context");
    }
}
