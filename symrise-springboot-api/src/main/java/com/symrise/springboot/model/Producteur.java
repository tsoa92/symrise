package com.symrise.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producteur")
public class Producteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String zone;
	private String fokontany;
	private Date inscription;
	private String nom;
	private String genre;
	private Date naissance;
	private String compte;	
	@Column(columnDefinition="TEXT", nullable = true)
	private String erreur;
	
	public Producteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Producteur(String zone, String fokontany, Date inscription, String nom, String genre, Date naissance,
			String compte, String erreur) {
		super();
		this.zone = zone;
		this.fokontany = fokontany;
		this.inscription = inscription;
		this.nom = nom;
		this.genre = genre;
		this.naissance = naissance;
		this.compte = compte;
		this.erreur = erreur;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getFokontany() {
		return fokontany;
	}

	public void setFokontany(String fokontany) {
		this.fokontany = fokontany;
	}

	public Date getInscription() {
		return inscription;
	}

	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public String getCompte() {
		return compte;
	}

	public void setCompte(String compte) {
		this.compte = compte;
	}

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", zone=" + zone + ", fokontany=" + fokontany + ", inscription=" + inscription + ", nom=" + nom + ""
				+ ", genre=" + genre + ", naissance=" + naissance + ", compte=" + compte + ", erreur=" + erreur + "]";
	}

}
