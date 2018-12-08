package com.Harjoitustyo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	 @RequestMapping(value="/episodes")
	    public String EpisodeList(Model model) {	
	        model.addAttribute("episodes", repository.findAll());
	        return "episodelist";
	    }
	 
	
	  
		// RESTful service to get all Episodes in a json type
	    @RequestMapping(value="/episodes", method = RequestMethod.GET)
	    public @ResponseBody List<Episode> EpisodeListRest() {	
	        return (List<Episode>) repository.findAll();
	    }    

		// RESTful service to get student by id
	    @RequestMapping(value="/episode/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Episode> findStudentRest(@PathVariable("id") Long EpisodeId) {	
	    	return repository.findById(EpisodeId);
	    
		}
		
		@RequestMapping(value = "/episodelist")
		public String episodeList(Model model) {
	    	model.addAttribute("episodes", repository.findAll());
			return "episodelist";
		}
		@RequestMapping(value = "/save-episode", method = RequestMethod.POST)
		public String save2(Episode episode) {
			repository.save(episode);
			return "redirect:episodelist";
		}

		@RequestMapping(value = "/addepisodes")
		public String addepisode(Model model) {
			model.addAttribute("episode", new Episode());
			return "addepisodes";
		}

		@RequestMapping(value = "/editepisode/{id}")
		public String editepisode(@PathVariable("id") Long EpisodeId, Model model) {
			model.addAttribute("episode", repository.findById(EpisodeId));
			return "editepisode";
		}
	}
