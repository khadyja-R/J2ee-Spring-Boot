package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Service.IBanqueService;

@SpringBootApplication
public class GestionComptesApplication implements CommandLineRunner {
 @Autowired
  private IBanqueService banqueservice;

	public static void main(String[] args) {
		SpringApplication.run(GestionComptesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}

}
