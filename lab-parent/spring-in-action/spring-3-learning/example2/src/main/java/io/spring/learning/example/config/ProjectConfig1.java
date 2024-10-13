package io.spring.learning.example.config;

import io.spring.learning.example.beans.Vehicle;
import io.spring.learning.example.beans.Vehicle1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {io.spring.learning.example.beans.Person1.class,
        io.spring.learning.example.beans.Vehicle1.class})
public class ProjectConfig1 {

    @Bean
    Vehicle1 vehicle1(){
        var vehicle = new Vehicle1();
        vehicle.setName("Audi");
        return vehicle;
    }

    @Bean
    Vehicle1 vehicle2(){
        var vehicle = new Vehicle1();
        vehicle.setName("Mercedes");
        return vehicle;
    }
    @Bean
    Vehicle1 vehicle3(){
        var vehicle = new Vehicle1();
        vehicle.setName("Ferrari");
        return vehicle;
    }


}
