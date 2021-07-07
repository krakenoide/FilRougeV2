package com.springmvc.testspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.testspringboot.jpa.AlbumRepository;
import com.springmvc.testspringboot.jpa.ArtisteRepository;
import com.springmvc.testspringboot.jpa.GenreRepository;
import com.springmvc.testspringboot.jpa.MorceauRepository;
import com.springmvc.testspringboot.jpa.PlaylistRepository;
import com.springmvc.testspringboot.jpa.UtilisateurRepository;
import com.springmvc.testspringboot.modeles.Album;
import com.springmvc.testspringboot.modeles.Artiste;
import com.springmvc.testspringboot.modeles.Genre;
import com.springmvc.testspringboot.modeles.Morceau;
import com.springmvc.testspringboot.modeles.Playlist;
import com.springmvc.testspringboot.modeles.Utilisateur;

@Service
public class Services implements IServices{
	
	@Autowired
	private MorceauRepository morceauJpa;
	@Autowired
	private GenreRepository genreJpa;
	@Autowired 
	private ArtisteRepository artisteJpa;
	@Autowired 
	private AlbumRepository albumJpa;
	@Autowired 
	private PlaylistRepository playlistJpa;
	@Autowired 
	private UtilisateurRepository utilisateurJpa;
	
		
	// ################ Morceau ##################
	
	@Transactional
	public List<Morceau> getAllMorceaux(){
		return morceauJpa.findAll();
	}
	
	@Transactional
	public Optional<Morceau> getMorceauWithID(int id){
		return morceauJpa.findById(id);
	}
	
	@Transactional
	public void deleteMorceau(int id){
		morceauJpa.deleteById(id);
	}
	
	@Transactional
	public void updateMorceau(Morceau m){
		morceauJpa.save(m);
	}
	
	@Transactional
	public void saveMorceau(Morceau m) {
		morceauJpa.save(m);
	}
	
	// ################ Album ##################
	
	@Transactional
	public List<Album> getAllAlbums(){
		return albumJpa.findAll();
	}
	
	@Transactional
	public Optional<Album> getAlbumWithID(int id){
		return albumJpa.findById(id);
	}
	
	@Transactional
	public void deleteAlbum(int id){
		albumJpa.deleteById(id);
	}
	
	@Transactional
	public void updateAlbum(Album m){
		albumJpa.save(m);
	}
	
	@Transactional
	public void saveAlbum(Album m) {
		albumJpa.save(m);
	}
	
	// ################ Artiste ##################
	
	@Transactional
	public List<Artiste> getAllArtistes(){
		return artisteJpa.findAll();
	}
	
	@Transactional
	public Optional<Artiste> getArtisteWithID(int id){
		return artisteJpa.findById(id);
	}
	
	@Transactional
	public void deleteArtiste(int id){
		artisteJpa.deleteById(id);
	}
	
	@Transactional
	public void updateArtiste(Artiste m){
		artisteJpa.save(m);
	}
	
	@Transactional
	public void saveArtiste(Artiste m) {
		artisteJpa.save(m);
	}
	
	// ################ Genre ##################
	
	@Transactional
	public List<Genre> getAllGenres(){
		return genreJpa.findAll();
	}
	
	@Transactional
	public Optional<Genre> getGenreWithID(int id){
		return genreJpa.findById(id);
	}
	
	@Transactional
	public void deleteGenre(int id){
		genreJpa.deleteById(id);
	}
	
	@Transactional
	public void updateGenre(Genre m){
		genreJpa.save(m);
	}
	
	@Transactional
	public void saveGenre(Genre m) {
		genreJpa.save(m);
	}

	// ################ Playlist ##################
	
	@Transactional
	public List<Playlist> getAllPlaylists(){
		return playlistJpa.findAll();
	}
	
	@Transactional
	public Optional<Playlist> getPlaylistWithID(int id){
		return playlistJpa.findById(id);
	}
	
	@Transactional
	public void deletePlaylist(int id){
		playlistJpa.deleteById(id);
	}
	
	@Transactional
	public void updatePlaylist(Playlist m){
		playlistJpa.save(m);
	}
	
	@Transactional
	public void savePlaylist(Playlist m) {
		playlistJpa.save(m);
	}
	
	// ################ Utilisateur ##################

	@Transactional
	public List<Utilisateur> getAllUtilisateurs(){
		return utilisateurJpa.findAll();
	}
	
	@Transactional
	public Optional<Utilisateur> getUtilisateurWithID(int id){
		return utilisateurJpa.findById(id);
	}
	
	@Transactional
	public void deleteUtilisateur(int id){
		utilisateurJpa.deleteById(id);
	}
	
	@Transactional
	public void updateUtilisateur(Utilisateur m){
		utilisateurJpa.save(m);
	}
	
	@Transactional
	public void saveUtilisateur(Utilisateur m) {
		utilisateurJpa.save(m);
	}


	
}
