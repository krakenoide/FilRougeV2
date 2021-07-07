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
import com.springmvc.testspringboot.modeles.Album;
import com.springmvc.testspringboot.modeles.Artiste;
import com.springmvc.testspringboot.services.IServices;

@RestController
@RequestMapping("/api/album") 
@CrossOrigin 
public class ControllerRestAlbum {
	
	@Autowired
	private IServices serv;
	
	@GetMapping("")
	public List<Album> getAlbum(){
		return serv.getAllAlbums();
	}
	
	@GetMapping("/{id}")
	public Optional<Album> getAlbum(@PathVariable int id){
		return serv.getAlbumWithID(id);
	}
	
	@PostMapping(value ="/")
	public Optional<Album> postAlbum(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Album m = objectMapper.readValue(pBody,Album.class);
		Optional<Artiste> tempArtiste = serv.getArtisteWithID(m.getArtiste().getId());
		if (tempArtiste != null) {
			m.setArtiste(tempArtiste.get());
		}
		
		serv.saveAlbum(m);
		return serv.getAlbumWithID(m.getId());
	}
	
	@PatchMapping(value ="/")
	public Optional<Album> patchAlbum(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Album m = objectMapper.readValue(pBody,Album.class);
		Optional<Artiste> tempArtiste = serv.getArtisteWithID(m.getArtiste().getId());
		if (tempArtiste != null) {
			m.setArtiste(tempArtiste.get());
		}
		serv.saveAlbum(m);
		return serv.getAlbumWithID(m.getId());
	}
	
	@DeleteMapping("/{id}")
	public void deleteAlbum(@PathVariable int id){
		serv.deleteAlbum(id);
	}
		
}
