package com.Harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

	@RepositoryRestResource
	public interface EpisodeRepository extends CrudRepository<Episode, Long> {

	    List<Episode> findByName(String name);
	    
	
}
