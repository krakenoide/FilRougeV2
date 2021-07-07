package com.springmvc.testspringboot.modeles;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // permet d'autoincrementer les id en mettant des null
	@Column(name = "id") // car mon nom de colomne est le meme que mon attribut
	private int id;
		

	@NotNull(message ="*") //if we try to make a Contact without giving it a new name i'll send an error
	@Pattern(regexp="[A-Za-z0-9 /]{0,40}",message="Veuillez ne pas utiliser de caracteres speciaux !")
	@Column(name="username")
	String nomDeCompte;
	@NotNull(message ="*") //if we try to make a Contact without giving it a new name i'll send an error
	@Size(min=5,message="Votre Mot de Passe doit contenir 5 caracteres au minimum !")
	@Column(name="password")
	@JsonIgnore
	String motDePasse; 
	@NotNull(message ="*") //if we try to make a Contact without giving it a new name i'll send an error
	@Column(name="authorities")
	String rolesUtilisateur;
		
	@OneToMany(mappedBy="createur", cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JsonIgnore
	List <Playlist> playlists;
		
	@Transient
	@JsonIgnore
	String nom;
	
	@Transient
	@JsonIgnore
	String prenom;
	
	@Transient
	@JsonIgnore
	String motDePasseVerification;
	
	public Utilisateur() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomDeCompte() {
		return nomDeCompte;
	}


	public void setNomDeCompte(String nomDeCompte) {
		this.nomDeCompte = nomDeCompte;
	}

	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getMotDePasseVerification() {
		return motDePasseVerification;
	}


	public void setMotDePasseVerification(String motDePasseVerification) {
		this.motDePasseVerification = motDePasseVerification;
	}
	
	public String getRolesUtilisateur() {
		return rolesUtilisateur;
	}


	public void setRolesUtilisateur(String rolesUtilisateur) {
		this.rolesUtilisateur = rolesUtilisateur;
	}



	public List<Playlist> getPlaylists() {
		return playlists;
	}


	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}


	public void addmymusic() {
		// TODO Auto-generated method stub
		
	}

}
