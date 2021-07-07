package com.springmvc.testspringboot.services;

import java.util.List;
import java.util.Optional;

import com.springmvc.testspringboot.modeles.Album;
import com.springmvc.testspringboot.modeles.Artiste;
import com.springmvc.testspringboot.modeles.Genre;
import com.springmvc.testspringboot.modeles.Morceau;
import com.springmvc.testspringboot.modeles.Playlist;
import com.springmvc.testspringboot.modeles.Son;
import com.springmvc.testspringboot.modeles.Utilisateur;

public interface IServices{
	
	// Interface Morceau
	public List<Morceau> getAllMorceaux();
	public Optional<Morceau> getMorceauWithID(int id);
	public void deleteMorceau(Morceau m);
	public void updateMorceau(Morceau m);
	public void saveMorceau(Morceau m);
	
	// Interface Artiste
	public List<Artiste> getAllArtistes();
	public Optional<Artiste> getArtisteWithID(int id);
	public void deleteArtiste(Artiste m);
	public void updateArtiste(Artiste m);
	public void saveArtiste(Artiste m);
	
	// Interface Album
	public List<Album> getAllAlbums();
	public Optional<Album> getAlbumWithID(int id);
	public void deleteAlbum(Album m);
	public void updateAlbum(Album m);
	public void saveAlbum(Album m);
	
	// Interface Genre
	public List<Genre> getAllGenres();
	public Optional<Genre> getGenreWithID(int id);
	public void deleteGenre(Genre m);
	public void updateGenre(Genre m);
	public void saveGenre(Genre m);
	
	// Interface Playlist
	public List<Playlist> getAllPlaylists();
	public Optional<Playlist> getPlaylistWithID(int id);
	public void deletePlaylist(Playlist m);
	public void updatePlaylist(Playlist m);
	public void savePlaylist(Playlist m);
	
	// Interface Son
	public List<Son> getAllSons();
	public Optional<Son> getSonWithID(int id);
	public void deleteSon(Son m);
	public void updateSon(Son m);
	public void saveSon(Son m);
	
	// Interface Utilisateur
	public List<Utilisateur> getAllUtilisateurs();
	public Optional<Utilisateur> getUtilisateurWithID(int id);
	public void deleteUtilisateur(Utilisateur m);
	public void updateUtilisateur(Utilisateur m);
	public void saveUtilisateur(Utilisateur m);
			
}
