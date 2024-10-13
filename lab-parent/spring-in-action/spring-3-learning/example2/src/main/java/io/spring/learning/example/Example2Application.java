package io.spring.learning.example;

import io.spring.learning.example.beans.Person;
import io.spring.learning.example.beans.Vehicle;
import io.spring.learning.example.config.ProjectConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Example2Application {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Person person = context.getBean(Person.class);
		Vehicle vehicle = context.getBean(Vehicle.class);
		System.out.println("Person name from the Spring Context is: "+ person.getName());
		System.out.println("Vehicle name from the Spring Context is: "+ vehicle.getName());
		System.out.println("Vehicle the Person own is: "+ person.getVehicle());
	}

}
