package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Flight;

import java.util.List;
import java.util.Optional;


public interface FlightRepo extends JpaRepository<Flight,String> {

	
}
