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
import com.springmvc.testspringboot.modeles.Playlist;
import com.springmvc.testspringboot.services.IServices;

@RestController
@RequestMapping("/api/playlist") 
@CrossOrigin 
public class ControllerRestPlaylist {
	
	@Autowired
	private IServices serv;
	
	@GetMapping("")
	public List<Playlist> getPlaylist(){
		return serv.getAllPlaylists();
	}
	
	@GetMapping("/{id}")
	public Optional<Playlist> getPlaylist(@PathVariable int id){
		return serv.getPlaylistWithID(id);
	}
	
	@PostMapping(value ="/")
	public Optional<Playlist> postPlaylist(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Playlist m = objectMapper.readValue(pBody,Playlist.class);
		serv.savePlaylist(m);
		return serv.getPlaylistWithID(m.getId());
	}
	
	@PatchMapping(value ="/")
	public Optional<Playlist> patchPlaylist(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Playlist m = objectMapper.readValue(pBody,Playlist.class);
		serv.savePlaylist(m);
		return serv.getPlaylistWithID(m.getId());
	}
	
	@DeleteMapping("/{id}")
	public void deletePlaylist(@PathVariable int id){
		serv.deletePlaylist(id);
	}
		
}
