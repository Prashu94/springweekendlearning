package io.spring.learning.example;

import io.spring.learning.example.beans.Person;
import io.spring.learning.example.beans.Vehicle;
import io.spring.learning.example.config.ProjectConfigMultipleBeans;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example9Application {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfigMultipleBeans.class);
        Person person = context.getBean(Person.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Person name from Spring Context is: " + person.getName());
        System.out.println("Vehicle name from Spring Context is: " + vehicle.getName());
        System.out.println("Vehicle that Person own is: " + person.getVehicle());
    }
}
