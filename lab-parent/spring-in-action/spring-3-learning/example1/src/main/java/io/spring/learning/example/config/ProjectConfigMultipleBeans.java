package io.spring.learning.example.config;

import io.spring.learning.example.beans.Person;
import io.spring.learning.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfigMultipleBeans {

    @Bean
    public Vehicle vehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Mercedes");
        return vehicle;
    }

    @Bean
    public Person person(){
        Person person = new Person();
        person.setName("John");
        person.setVehicle(vehicle());
        return person;
    }
}
