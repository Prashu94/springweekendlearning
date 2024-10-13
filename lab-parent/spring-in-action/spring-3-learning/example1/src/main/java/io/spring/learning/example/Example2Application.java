package io.spring.learning.example;

import io.spring.learning.example.beans.Vehicle;
import io.spring.learning.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2Application {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh = context.getBean("vehicle1", Vehicle.class);
        System.out.println("Vehicle name from spring managed object: " + veh.getName());
    }
}
