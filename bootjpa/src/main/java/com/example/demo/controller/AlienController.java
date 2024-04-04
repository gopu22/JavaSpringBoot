package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("okay");
		return "home.jsp";
	}
	
//	@PostMapping(path = "/alien", consumes = {"application/json"})  // This only accepts the JSON data from the client
	@PostMapping("/aliens")
	public Alien addAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	@GetMapping(path="/aliens")
	public List<Alien> getAliens()
	{
		
		return repo.findAll();

	}
	
	@DeleteMapping("/aliens/{aid}")
	public String deleteAlien(@PathVariable("aid") int aid)
	{
		Alien a = repo.getOne(aid);
		
		repo.delete(a);
		
		return "Deleted Successfully";
	}
	
	@PutMapping("/aliens")
	public Alien updateAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}

	
// This prints data based on the entered id.
	@RequestMapping("/aliens/{aid}")  // whatever id entered here same id will be added to the @pathvariable below.
	public Optional<Alien> getAlien(@PathVariable("aid") int aid)
	{
		
		return repo.findById(aid);

	}

}
