package io.spring.learning.example.beans;


public class Vehicle {

    public Vehicle(){
        System.out.println("Vehicle bean created by Spring");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello(){
        System.out.println("Printing Hello from Component From Vehicle Bean ");
    }

    public String toString(){
        return "Vehicle Name: "+name;
    }
}
