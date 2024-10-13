package io.spring.learning.example;

import io.spring.learning.example.beans.Person;
import io.spring.learning.example.beans.Vehicle;
import io.spring.learning.example.config.ProjectConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Example3Application {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		String [] persons = context.getBeanNamesForType(Person.class);
		Person person = context.getBean(Person.class);

		String [] names = context.getBeanNamesForType(Vehicle.class);

		person.getVehicle().getVehicleServices().playMusic();
		person.getVehicle().getVehicleServices().moveVehicle();
	}

}
