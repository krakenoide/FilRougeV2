package com.springmvc.testspringboot.controleurs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.testspringboot.modeles.Genre;
import com.springmvc.testspringboot.modeles.Morceau;
import com.springmvc.testspringboot.services.IServices;

@RestController
@RequestMapping("/api/morceau") 
@CrossOrigin 
public class ControllerRestMorceau {
	
	@Autowired
	private IServices serv;
	
	@GetMapping("/")
	public List<Morceau> getMorceaux(){
		return serv.getAllMorceaux();
	}
	
	@GetMapping("/{id}")
	public Optional<Morceau> getMorceau(@PathVariable int id){
		return serv.getMorceauWithID(id);
	}
	
	@PostMapping("/")
	public Optional<Morceau> postMorceau(){
		return serv.getMorceauWithID(id);
	}
	
	@DeleteMapping("/{id}")
	public Optional<Morceau> deleteMorceau(){
		return serv.delete(id);
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
