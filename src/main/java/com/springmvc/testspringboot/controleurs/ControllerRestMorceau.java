package com.springmvc.testspringboot.controleurs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmvc.testspringboot.modeles.Album;
import com.springmvc.testspringboot.modeles.Artiste;
import com.springmvc.testspringboot.modeles.Genre;
import com.springmvc.testspringboot.modeles.Morceau;
import com.springmvc.testspringboot.services.IServices;

@RestController
@RequestMapping("/api/morceau") 
@CrossOrigin 
public class ControllerRestMorceau {
	
	@Autowired
	private IServices serv;
	
	@GetMapping("")
	public List<Morceau> getMorceau(){
		return serv.getAllMorceaux();
	}
	
	@GetMapping("/{id}")
	public Optional<Morceau> getMorceau(@PathVariable int id){
		return serv.getMorceauWithID(id);
	}
	
	@PostMapping(value ="/")
	public Optional<Morceau> postMorceau(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Morceau m = objectMapper.readValue(pBody,Morceau.class);
		Optional<Artiste> tempArtiste = serv.getArtisteWithID(m.getArtiste().getId());
		Optional<Album> tempAlbum = serv.getAlbumWithID(m.getAlbum().getId());
		if (tempArtiste != null) {
			m.setArtiste(tempArtiste.get());
		}
		if (tempAlbum != null) {
			if (tempArtiste != null) {
				tempAlbum.get().setArtiste(tempArtiste.get());
			}
			m.setAlbum(tempAlbum.get());
		}	
				
		serv.saveMorceau(m);
		return serv.getMorceauWithID(m.getId());
	}
	
	@PatchMapping(value ="/")
	public Optional<Morceau> patchMorceau(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Morceau m = objectMapper.readValue(pBody,Morceau.class);
		Optional<Artiste> tempArtiste = serv.getArtisteWithID(m.getArtiste().getId());
		Optional<Album> tempAlbum = serv.getAlbumWithID(m.getAlbum().getId());
		if (tempArtiste != null) {
			m.setArtiste(tempArtiste.get());
		}
		if (tempAlbum != null) {
			if (tempArtiste != null) {
				tempAlbum.get().setArtiste(tempArtiste.get());
			}
			m.setAlbum(tempAlbum.get());
		}	
				
		serv.saveMorceau(m);
		return serv.getMorceauWithID(m.getId());
	}
	
	@DeleteMapping("/{id}")
	public void deleteMorceau(@PathVariable int id){
		serv.deleteMorceau(id);
	}
		
}
