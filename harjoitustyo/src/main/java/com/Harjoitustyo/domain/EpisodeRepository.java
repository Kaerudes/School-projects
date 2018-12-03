package com.Harjoitustyo.domain;

import java.util.List;

	import org.springframework.data.repository.CrudRepository;

	public interface EpisodeRepository extends CrudRepository<Episode, Long> {

	    List<Episode> findByname(String name);
	    
	
}
