package com.newproject.newproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.newproject.newproject.model.Alien;
import com.newproject.newproject.repo.AlienRepo;

@SpringBootApplication
public class NewprojectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NewprojectApplication.class, args);

		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(111);
		alien1.setName("Raj");
		alien1.setTech("Java");

		AlienRepo alienRepo = context.getBean(AlienRepo.class);
		alienRepo.save(alien1);
		alienRepo.findAll().forEach(System.out::println);
	}

}
