package com.Harjoitustyo.harjoitustyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.Harjoitustyo.domain.Episode;
import com.Harjoitustyo.domain.EpisodeRepository;

@SpringBootApplication
public class HarjoitustyoApplication {
	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	@Bean
	public CommandLineRunner episodeDemo(EpisodeRepository repository) {
		return (args) -> {
			log.info("saving a couple of episodes");
			repository.save(new Episode( "Jaksonnimi","Jakosn","asd","asd","asd"));
			
			log.info("fetch all episodes");
			
		
	};
	
	
	}
}
