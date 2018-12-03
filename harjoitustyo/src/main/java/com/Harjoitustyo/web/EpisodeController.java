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
	
	 @RequestMapping(value="/episodelist")
	    public String EpisodeList(Model model) {	
	        model.addAttribute("episodes", repository.findAll());
	        return "studentlist";
	    }
	  
		// RESTful service to get all students
	    @RequestMapping(value="/episodes", method = RequestMethod.GET)
	    public @ResponseBody List<Episode> EpisodeListRest() {	
	        return (List<Episode>) repository.findAll();
	    }    

		// RESTful service to get student by id
	    @RequestMapping(value="/student/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Episode> findStudentRest(@PathVariable("id") Long EpisodeId) {	
	    	return repository.findById(EpisodeId);
	    }       
	    
	    // Add new student
	    @RequestMapping(value = "/add")
	    public String addStudent(Model model){
	    	model.addAttribute("episode", new Episode());
	    	model.addAttribute("Episodes", repository.findAll());
	        return "addEpisode";
	    }     
	    
	    // Save new student
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Episode episode){
	        repository.save(episode);
	        return "redirect:episodelist";
	    }    

	    // Delete student
	 /*   @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteEpisode(@PathVariable("id") Long Episode, Model model) {
	    	repository.deleteById(EpisodeId);
	        return "redirect:../studentlist";
	        */
	    }     

	

	

