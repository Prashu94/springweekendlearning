package io.spring.learning.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person1 {

    private String name = "Prashant";
    private final Vehicle1 vehicle;

    @Autowired
    public Person1(@Qualifier("vehicle2") Vehicle1 vehicle){
        System.out.println("Person1 bean created by Spring");
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle1 getVehicle() {
        return vehicle;
    }
}
