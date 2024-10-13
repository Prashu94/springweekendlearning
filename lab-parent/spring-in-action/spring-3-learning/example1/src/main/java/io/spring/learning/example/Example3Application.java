package io.spring.learning.example;

import io.spring.learning.example.beans.Vehicle;
import io.spring.learning.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example3Application {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh1 = context.getBean("mercedesVehicle", Vehicle.class);
        System.out.println("Vehicle name from spring context: " + veh1.getName());
        Vehicle veh2 = context.getBean("hondaVehicle", Vehicle.class);
        System.out.println("Vehicle name from spring context: " + veh2.getName());
        Vehicle veh3 = context.getBean("ferrariVehicle", Vehicle.class);
        System.out.println("Vehicle name from spring context: " + veh3.getName());
        Vehicle veh4 = context.getBean("hyundaiVehicle", Vehicle.class);
        System.out.println("Vehicle name from spring context: " + veh4.getName());
    }
}
