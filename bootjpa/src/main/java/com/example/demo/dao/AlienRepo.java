// It is an java interface here

package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

//public interface AlienRepo extends CrudRepository<Alien, Integer>
public interface AlienRepo extends JpaRepository<Alien, Integer> 
{
	
}
