package com.example.prisoner;

import com.example.prisoner.models.Prison;
import com.example.prisoner.repository.PrisonRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrisonerApplication {
	Logger logger = LoggerFactory.getLogger(PrisonerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PrisonerApplication.class, args);
	}


	@Autowired
	PrisonRepository prisonRepository;


	@Bean
	ApplicationListener<ApplicationReadyEvent> ready(){
		return event -> {
			Prison p = new Prison("Hell prison",4);
			prisonRepository.save(p);
		};
	}

	@Bean
	ApplicationListener<AvailabilityChangeEvent<LivenessState>> change(){
		return event -> System.out.println("availability changed + " + event.getState());
	}



	@Bean
	ApplicationListener<MyEvent> myEvent(){

		return event -> {
			logger.info(event.getMessage());
			System.out.println(event.getMessage());
		};
	}



}



