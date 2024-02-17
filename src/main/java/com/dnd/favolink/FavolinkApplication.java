package com.dnd.favolink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FavolinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavolinkApplication.class, args);
	}

}
