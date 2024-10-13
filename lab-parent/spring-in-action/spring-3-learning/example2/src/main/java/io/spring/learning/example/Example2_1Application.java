package io.spring.learning.example;

import io.spring.learning.example.beans.Person;
import io.spring.learning.example.beans.Person1;
import io.spring.learning.example.config.ProjectConfig1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2_1Application {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig1.class);
        Person1 person = context.getBean(Person1.class);
        System.out.println("Person name is - "+person.getName());
        System.out.println("PERSON VEHICLE - "+person.getVehicle());
    }
}
