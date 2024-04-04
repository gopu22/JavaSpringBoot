package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("okay");
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "home.jsp";
	}
	
//	@RequestMapping(path="/aliens",produces={"application/xml"})  // This gets the output only in xml format, if we try to get the output in other format like JSON we get errors.
	@RequestMapping("/aliens")
	@ResponseBody
	public List<Alien> getAliens()
	{
		
		return repo.findAll();

	}

// This is for single entries.
//	@RequestMapping("/aliens/102")
//	@ResponseBody
//	public String getAlien()
//	{
//		
//		return repo.findById(102).toString();
//
//	}
	
// This prints data based on the entered id.
	@RequestMapping("/aliens/{aid}")  // whatever id entered here same id will be added to the @pathvariable below.
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid)
	{
		
		return repo.findById(aid);

	}

}
