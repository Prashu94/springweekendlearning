package io.spring.learning.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "io.spring.learning.example.proxy")
public class Example6clientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Example6clientApplication.class, args);
	}

}
