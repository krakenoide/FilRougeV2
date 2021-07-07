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
import com.springmvc.testspringboot.modeles.Utilisateur;
import com.springmvc.testspringboot.services.IServices;

@RestController
@RequestMapping("/api/user") 
@CrossOrigin 
public class ControllerRestUtilisateur {
	
	@Autowired
	private IServices serv;
	
	@GetMapping("")
	public List<Utilisateur> getUtilisateur(){
		return serv.getAllUtilisateurs();
	}
	
	@GetMapping("/{id}")
	public Optional<Utilisateur> getUtilisateur(@PathVariable int id){
		return serv.getUtilisateurWithID(id);
	}
	
	@PostMapping(value ="/")
	public Optional<Utilisateur> postUtilisateur(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Utilisateur m = objectMapper.readValue(pBody,Utilisateur.class);
	
		serv.saveUtilisateur(m);
		return serv.getUtilisateurWithID(m.getId());
	}
	
	@PatchMapping(value ="/")
	public Optional<Utilisateur> patchUtilisateur(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Utilisateur m = objectMapper.readValue(pBody,Utilisateur.class);
		
		serv.saveUtilisateur(m);
		return serv.getUtilisateurWithID(m.getId());
	}
	
	@DeleteMapping("/{id}")
	public void deleteUtilisateur(@PathVariable int id){
		serv.deleteUtilisateur(id);
	}
		
}
