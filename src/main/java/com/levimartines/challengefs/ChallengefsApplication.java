package com.levimartines.challengefs;

import com.levimartines.challengefs.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengefsApplication implements CommandLineRunner {

	@Autowired
	private DbService dbService;

	public static void main(String[] args){
		SpringApplication.run(ChallengefsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dbService.instantiateTestDatabase();
	}
}
