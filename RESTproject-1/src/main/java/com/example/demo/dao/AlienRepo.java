package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Alienobject;


public interface AlienRepo extends JpaRepository<Alienobject, Integer> 
{
	
}
