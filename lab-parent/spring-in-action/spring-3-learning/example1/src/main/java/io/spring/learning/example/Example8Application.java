package io.spring.learning.example;

import io.spring.learning.example.beans.Vehicle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example8Application {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("beans.xml");
        Vehicle vehicle = context.getBean("vehicle", Vehicle.class);
        System.out.println("Vehicle name from Spring Context XML is: "+ vehicle.getName());
    }
}
