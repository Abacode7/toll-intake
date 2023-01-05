package com.pluralsight.tollintake;

import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TollIntakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollIntakeApplication.class, args);
	}

	@Bean
	public Consumer<FastPassToll> receiveTollChargesSlow(){
		return value -> {
			System.out.println("received toll charge (slow) " + value.getFastPassId() + " at time: " + Instant.now().toString());
		};
	}

	@Bean
	public Consumer<FastPassToll> receiveTollChargesFast(){
		return value -> {
			System.out.println("received toll charge (fast) " + value.getFastPassId() + " at time: " + Instant.now().toString());
		};
	}

	//@Bean
	public Function<FastPassToll, FastPassToll> processTollCharges(){
		return value -> {
			System.out.println("Processing message");
			value.setStatus("processed");
			return value;
		};
	}
}
