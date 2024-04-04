package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AlienRepo;
import com.example.demo.exception.BankingNotFoundException;
import com.example.demo.model.Alienobject;

@RestController
public class AlienController 
{
	@Autowired
	AlienRepo repo;
	
	@GetMapping("/aliens")
	public List<Alienobject> getAliens()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/aliens/{aid}")
	public Optional<Alienobject> getAlien(@PathVariable("aid") int aid)
	{
		if(repo.findById(aid).isEmpty())
			throw new BankingNotFoundException("Requested id does not exist");
		return repo.findById(aid);
	}
	
	@PostMapping("/aliens")
	public Alienobject addAlien(@RequestBody Alienobject alien)
	{
		repo.save(alien);
		return alien;
	}
	
	@PutMapping("/aliens")
	public String updateAlien(@RequestBody Alienobject alien)
	{
		repo.save(alien);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/aliens/{aid}")
	public String deleteAlien(@PathVariable("aid") int aid)
	{
		Alienobject a = repo.getOne(aid);
		repo.delete(a);
		return "Deleted Successfully";
	}

}
