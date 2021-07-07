package com.springmvc.testspringboot.controleurs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmvc.testspringboot.modeles.Genre;
import com.springmvc.testspringboot.modeles.Artiste;
import com.springmvc.testspringboot.services.IServices;

@RestController
@RequestMapping("/api/genre") 
@CrossOrigin 
public class ControllerRestGenre {
	
	@Autowired
	private IServices serv;
	
	@GetMapping("")
	public List<Genre> getGenre(){
		return serv.getAllGenres();
	}
	
	@GetMapping("/{id}")
	public Optional<Genre> getGenre(@PathVariable int id){
		return serv.getGenreWithID(id);
	}
	
	@PostMapping(value ="/")
	public Optional<Genre> postGenre(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Genre m = objectMapper.readValue(pBody,Genre.class);
		serv.saveGenre(m);
		return serv.getGenreWithID(m.getId());
	}
	
	@PatchMapping(value ="/")
	public Optional<Genre> patchGenre(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Genre m = objectMapper.readValue(pBody,Genre.class);
		serv.saveGenre(m);
		return serv.getGenreWithID(m.getId());
	}
	
	@DeleteMapping("/{id}")
	public void deleteGenre(@PathVariable int id){
		serv.deleteGenre(id);
	}
		
}
