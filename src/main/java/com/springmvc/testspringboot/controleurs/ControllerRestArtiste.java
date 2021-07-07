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
import com.springmvc.testspringboot.modeles.Artiste;
import com.springmvc.testspringboot.services.IServices;

@RestController
@RequestMapping("/api/artiste") 
@CrossOrigin 
public class ControllerRestArtiste {
	
	@Autowired
	private IServices serv;
	
	@GetMapping("")
	public List<Artiste> getArtiste(){
		return serv.getAllArtistes();
	}
	
	@GetMapping("/{id}")
	public Optional<Artiste> getArtiste(@PathVariable int id){
		return serv.getArtisteWithID(id);
	}
	
	@PostMapping(value ="/")
	public Optional<Artiste> postArtiste(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Artiste m = objectMapper.readValue(pBody,Artiste.class);
		serv.saveArtiste(m);
		return serv.getArtisteWithID(m.getId());
	}
	
	@PatchMapping(value ="/")
	public Optional<Artiste> patchArtiste(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Artiste m = objectMapper.readValue(pBody,Artiste.class);
		serv.saveArtiste(m);
		return serv.getArtisteWithID(m.getId());
	}
	
	@DeleteMapping("/{id}")
	public void deleteArtiste(@PathVariable int id){
		serv.deleteArtiste(id);
	}
		
}
