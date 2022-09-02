package com.example.demo.controller;


import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import com.example.demo.dao.FlightRepo;
import com.example.demo.model.Flight;

@RestController
public class FlightController {

	@Autowired
	FlightRepo repo;

	
	@GetMapping("/flights")
	public List<Flight> getAll (String sortBy) {
		Sort sortOrder = Sort.by("duration"); 
     	List<Flight> list = repo.findAll(sortOrder);
    	return list;
	}
	
	@PostMapping(path="/flight",consumes= {"application/json"})
	public Flight addFlight(@RequestBody Flight flight)
	{
		repo.save(flight);
		return flight;
	}
	
	@PutMapping(path="/flight",consumes= {"application/json"})
	public Flight saveOrUpdateFlight(@RequestBody Flight flight)
	{
		repo.save(flight);
		return flight;
	}
	
	@DeleteMapping("/flight/{flightNumber}")
	public String deleteFlight(@PathVariable String flightNumber)
	{
		Flight a = repo.getOne(flightNumber);
		repo.delete(a);
		return "deleted";
	}
	
	@RequestMapping("/flight/{flightNumber}")
	public Optional<Flight> getFlight(@PathVariable("flightNumber")String flightNumber)
	{
		return repo.findById(flightNumber);	
	}
	
}
