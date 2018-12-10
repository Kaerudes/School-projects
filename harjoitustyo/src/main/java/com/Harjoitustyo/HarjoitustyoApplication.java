package com.Harjoitustyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Harjoitustyo.domain.Episode;
import com.Harjoitustyo.domain.EpisodeRepository;

import com.Harjoitustyo.domain.User;
import com.Harjoitustyo.domain.UserRepository;

@SpringBootApplication
public class HarjoitustyoApplication {
	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner episodeDemo(EpisodeRepository repository, UserRepository urepository) {
		return (args) -> {
			
			//Syötetään muutama testi jakso tietokantaan ja kirjataan logiin tapahtuma
			log.info("saving a couple of episodes");
			repository.save(new Episode( "Pilot","Robert Mander","September 10, 1993","45","12"));
			repository.save(new Episode( "Deep Throat","Daniel Sackheim","September 17, 1993","44","11"));
			repository.save(new Episode( "Squeeze","Harry Longstreet","September 24, 1993","46","13"));
			repository.save(new Episode( "Conduit","William Graham	","October 1, 1993","46","12"));
			repository.save(new Episode( "The Jersey Devil","Daniel Sackheim","October 8, 1993","46","14"));
			repository.save(new Episode( "Shadows","Jerrold Freedman","October 22, 1993	","43","22"));
			repository.save(new Episode( "Ghost in the Machine","William Graham	","October 29, 1993	","46","13"));
			repository.save(new Episode( "Ice","Daniel Sackheim","November 5, 1993	","47","14"));
			repository.save(new Episode( "Space","Jerrold Freedman","November 12, 1993	","48","11"));
			repository.save(new Episode( "Fallen Angel","Daniel Sackheim","November 19, 1993","42","14"));
			repository.save(new Episode( "Eve","William Graham	","December 10, 1993","43","13"));
			repository.save(new Episode( "Fire","Daniel Sackheim","December 17, 1993","45","11"));
			repository.save(new Episode( "Beyond the Sea","Jerrold Freedman","January 7, 1994","44","12"));
			repository.save(new Episode( "Lazarus","Daniel Sackheim","January 21, 1994","47","16"));
			
			log.info("creating example users");
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all episodes");
			
		
	};
	
	
	}
}
