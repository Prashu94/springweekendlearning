package io.spring.learning.example;

import io.spring.learning.example.beans.Vehicle;
import io.spring.learning.example.config.ProjectConfigComponentScan;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example7Application {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfigComponentScan.class);

        Vehicle mercedes = new Vehicle();
        mercedes.setName("Mercedes");
        Supplier<Vehicle> mercedesSupplier = () -> mercedes;

        Supplier<Vehicle> ferrariSupplier = () -> {
            Vehicle ferrari = new Vehicle();
            ferrari.setName("Ferrari");
            return ferrari;
        };


        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("randomNumber = " + randomNumber);

        if((randomNumber % 2) == 0 ){
            context.registerBean("mercedes", Vehicle.class, mercedesSupplier);
        }else{
            context.registerBean("ferrari", Vehicle.class, ferrariSupplier);
        }

        Vehicle mercedesVehicle = null;
        Vehicle ferrariVehicle = null;
        try{
            mercedesVehicle = context.getBean("mercedes", Vehicle.class);
        }catch (NoSuchBeanDefinitionException exception){
            System.out.println("Mercedes bean not found");
        }

        try{
            ferrariVehicle = context.getBean("ferrari", Vehicle.class);
        }catch (NoSuchBeanDefinitionException exception){
            System.out.println("Ferrari bean not found");
        }

        if(null != mercedesVehicle){
            System.out.println(" vehicle name = " + mercedesVehicle.getName());
        }else {
            System.out.println(" vehicle name = " + ferrariVehicle.getName());
        }

    }
}
