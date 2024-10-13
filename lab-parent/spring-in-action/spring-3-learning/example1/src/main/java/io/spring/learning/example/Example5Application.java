package io.spring.learning.example;


import io.spring.learning.example.beans.Vehicle1;
import io.spring.learning.example.config.ProjectConfigComponentScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example5Application {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfigComponentScan.class);
        Vehicle1 vehicle = context.getBean(Vehicle1.class);
        // If you don't initialize the name variable through constructor or through @PostContruct
        // and then the name variable will be null
        System.out.println("Component Vehicle name from Spring Context is "+ vehicle.getName());
        vehicle.printHello();
    }
}
