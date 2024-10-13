package io.spring.learning.example;

import io.spring.learning.example.config.ProjectConfig;
import io.spring.learning.example.model.Song;
import io.spring.learning.example.services.VehicleServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Example4Application {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var vehicleServices = context.getBean(VehicleServices.class);
		System.out.println(vehicleServices.getClass());
		Song song = new Song();
		song.setTitle("Blank Space");
		song.setSingerName("Taylor Swift");
		boolean vehicleStarted = true;
		String moveVehicleStatus = vehicleServices.moveVehicle(vehicleStarted);
		String playMusicStatus = vehicleServices.playMusic(vehicleStarted,song);
		String applyBrakeStatus = vehicleServices.applyBrake(vehicleStarted);
	}

}
