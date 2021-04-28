package com.example.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SampleApplication {

	private static final Logger log = LoggerFactory.getLogger(SampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(StudentRepositary repository){
		return(args) -> {
			// save a few students
			repository.save(new Student("Jack", "Bauer"));
			repository.save(new Student("Chloe", "O'Brian"));
			repository.save(new Student("Kim", "Bauer"));
			repository.save(new Student("David", "Palmer"));
			repository.save(new Student("Michelle", "Dessler"));

			// fetch all students
			log.info("Student found with findAll():");
			log.info("-------------------------------");
			for (Student student : repository.findAll()) {
				log.info(student.toString());
			}
			log.info("");

			// fetch an individual student by ID
			Student student = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(student.toString());
			log.info("");

			// fetch students by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});

			log.info("");
		};
	}
}
