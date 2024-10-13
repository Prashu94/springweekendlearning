package io.spring.learning.example.config;

import io.spring.learning.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean(name = "mercedesVehicle")
    Vehicle vehicle(){
        var veh  = new Vehicle();
        veh.setName("Mercedes");
        return veh;
    }

    @Bean(name = "hondaVehicle")
    Vehicle vehicle1(){
        var veh  = new Vehicle();
        veh.setName("Honda");
        return veh;
    }

    @Primary
    @Bean(name = "ferrariVehicle")
    Vehicle vehicle2(){
        var veh  = new Vehicle();
        veh.setName("Ferrari");
        return veh;
    }


    @Bean(name = "hyundaiVehicle")
    Vehicle vehicle3(){
        var veh  = new Vehicle();
        veh.setName("Hyundai");
        return veh;
    }

    @Bean
    String hello(){
        return "hello world";
    }

    @Bean
    Integer number(){
        return 16;
    }

    @Bean(name = "hello1")
    String hello1(){
        return "hello world1";
    }
}
