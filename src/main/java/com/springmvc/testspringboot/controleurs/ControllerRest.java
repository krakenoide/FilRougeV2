package com.springmvc.testspringboot.controleurs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.testspringboot.modeles.Genre;
import com.springmvc.testspringboot.modeles.Morceau;
import com.springmvc.testspringboot.services.IServices;

@RestController
@RequestMapping("/api") 
@CrossOrigin 
public class ControllerRest {
	
	@Autowired
	private IServices serv;
	
	@GetMapping("/morceaux")
	public List<Morceau> getMorceaux(){
		return serv.getAllMorceaux();
	}
	
	@GetMapping("/morceau/{id}")
	public Optional<Morceau> getMorceau(@PathVariable int id){
		return serv.getMorceauWithID(id);
	}
		
	@GetMapping("/genres")
	public List<Genre> getGenre(){
		return serv.getAllGenres();
	}
	
	@GetMapping("/genres/{id}")
	public Optional<Genre> getGenreWithID(@PathVariable int id){
		return serv.getGenreWithID(id);
	}
	
}
