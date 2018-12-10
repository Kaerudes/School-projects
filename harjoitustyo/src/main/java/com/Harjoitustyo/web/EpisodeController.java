package com.Harjoitustyo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Harjoitustyo.domain.Episode;
import com.Harjoitustyo.domain.EpisodeRepository;


@Controller
public class EpisodeController {
	
	@Autowired
	private EpisodeRepository repository;
	
	
	// Endpoint for Loginpage.
	 @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }	


		// RESTful service to get all Episodes in a json type
	    @RequestMapping(value="/episodes", method = RequestMethod.GET)
	    public @ResponseBody List<Episode> EpisodeListRest() {	
	        return (List<Episode>) repository.findAll();
	    }    

		// RESTful service to get episode by id
	    @RequestMapping(value="/episode/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Episode> findEpisodeRest(@PathVariable("id") Long EpisodeId) {	
	    	return repository.findById(EpisodeId);
	    
		}
		
	    // RESTful for Mapping the episodes in HTML table
		@RequestMapping(value = "/episodelist")
		public String episodeList(Model model) {
	    	model.addAttribute("episodes", repository.findAll());
			return "episodelist";
		}
		// RESTful for saving an episode
		@RequestMapping(value = "/save-episode", method = RequestMethod.POST)
		public String save2(Episode episode) {
			repository.save(episode);
			return "redirect:episodelist";
		}
		// RESTful for adding a brand new episode object (requires ADMIN user).
		@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/addepisodes")
		public String addepisode(Model model) {
			model.addAttribute("episode", new Episode());
			return "addepisodes";
		}
		// RESTful for editing an episode that is already in the database (Requires ADMIN user)
		@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/editepisode/{id}")
		public String editepisode(@PathVariable("id") Long EpisodeId, Model model) {
			model.addAttribute("episode", repository.findById(EpisodeId));
			return "editepisode";
		}
		
		// RESTful for Deleting an existing episode from the database (Requires ADMIN user)
		@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteEpisode(@PathVariable("id")Long EpisodeId,Model model) {
			repository.deleteById(EpisodeId);
			return "redirect:../episodelist";
		}
		
		
		
		// RESTful to show a single episode in a HTML table ( NOT IN USE / NOT YET WORKING) 
		/* @RequestMapping(value="/findone/{id}", method = RequestMethod.GET)
		    public String findOneRest(@PathVariable("id") Long EpisodeId,Model model){
			 repository.findById(EpisodeId);
			 return "one-episode";
		*/
	
		
}

