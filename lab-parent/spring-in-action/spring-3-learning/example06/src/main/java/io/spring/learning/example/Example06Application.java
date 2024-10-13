package io.spring.learning.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("io.spring.learning.example.repository")
@EntityScan("io.spring.learning.example.model")
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class Example06Application {

	public static void main(String[] args) {
		SpringApplication.run(Example06Application.class, args);
	}

}
