package com.springmvc.testspringboot.modeles;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "morceaux")
public class Morceau {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // permet d'autoincrementer les id en mettant des null
	@Column(name = "id") // car mon nom de colomne est le meme que mon attribut
	private int id;

	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "id_artiste")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Artiste artiste;

	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "id_album")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Album album;

	@NotNull(message ="*") //if we try to make a Contact without giving it a new name i'll send an error
//	@Size(min=4,message= "4 characters minimum")
	@Pattern(regexp="[A-Za-z0-9 /]{0,40}",message="Veuillez ne pas utiliser de caracteres speciaux !")
	@Column(name = "Nom")
	private String nomMorceau;

	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "id_genre")
	private Genre genre;

	@Column(name = "Duree")
	private int duree;

	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "id_son")
	@JsonIgnore
	private Son son;

	@Transient
	@Pattern(regexp="[A-Za-z0-9 /]{0,40}",message="Veuillez ne pas utiliser de caracteres speciaux !")
	@JsonIgnore
	private String nomAlbum;

	@Transient
	@Pattern(regexp="[A-Za-z0-9 /]{0,40}",message="Veuillez ne pas utiliser de caracteres speciaux !")
	@JsonIgnore
	private String nomArtiste;

	@Transient
	@Pattern(regexp="[A-Za-z0-9 /]{0,20}",message="*")
	@JsonIgnore
	private String nomGenreMorceau;
	
	public Morceau() {

	}

	public String getNomGenreMorceau() {
		return nomGenreMorceau;
	}

	public void setNomGenreMorceau(String nomGenreMorceau) {
		this.nomGenreMorceau = nomGenreMorceau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getNomMorceau() {
		return nomMorceau;
	}

	public void setNomMorceau(String nomMorceau) {
		this.nomMorceau = nomMorceau;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	
	public String getNomArtiste() {
		return nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	public String getNomAlbum() {
		return nomAlbum;
	}

	public void setNomAlbum(String nomAlbum) {
		this.nomAlbum = nomAlbum;
	}

	
	public Son getSon() {
		return son;
	}

	public void setSon(Son son) {
		this.son = son;
	}



}