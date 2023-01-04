package com.pluralsight.tollintake;

import java.time.Instant;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TollIntakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollIntakeApplication.class, args);
	}

	@Bean
	public Consumer<FastPassToll> receiveTollCharges(){
		return value -> {
			System.out.println("received toll charge " + value.fastPassId + " at time: " + Instant.now().toString());
		};
	}
}
