package com.springmvc.testspringboot.modeles;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="artistes")
public class Artiste {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id") 
	private int id;
	
	@Column(name="nom")
	private String nomArtiste;
	
	@Column(name = "url_photo")
	private String photoArtiste;

	@OneToMany(mappedBy="artiste",fetch=FetchType.LAZY,cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JsonIgnore
	private List<Album> albums;
	
	@OneToMany(mappedBy="artiste",fetch=FetchType.LAZY,cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JsonIgnore
	private List<Morceau> morceaux;
	
	public Artiste(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomArtiste() {
		return nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<Morceau> getMorceaux() {
		return morceaux;
	}

	public void setMorceaux(List<Morceau> morceaux) {
		this.morceaux = morceaux;
	}

	public String getPhotoArtiste() {
		return photoArtiste;
	}

	public void setPhotoArtiste(String photoArtiste) {
		this.photoArtiste = photoArtiste;
	}

		
	public String toString() {
		return nomArtiste;
	}

	

}