package io.spring.learning.example;

import io.spring.learning.example.beans.Vehicle;
import io.spring.learning.example.config.ProjectConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Example1Application {

	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		vehicle.setName("Honda");
		System.out.println("Vehicle name from non-spring managed object: " + vehicle.getName());

		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

		Vehicle veh = context.getBean(Vehicle.class); // default and primary bean
		System.out.println("Vehicle name from spring managed object: " + veh.getName());

		String hello = context.getBean("hello", String.class);
		System.out.println("String value from Spring Context is: "+ hello);
		Integer num = context.getBean(Integer.class);
		System.out.println("Integer value from Spring Context is: "+ num);
		String hello1 = context.getBean("hello1", String.class);
		System.out.println("String value from Spring Context with name hello1 is: "+ hello1);
	}

}
