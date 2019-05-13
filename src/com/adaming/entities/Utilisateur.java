package com.adaming.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUtilisateur;
	@Column(unique = true)
	private String username;
	private String password;
	private String email;
	private String nom;
	private String prenom;
	private boolean enabled = true;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "profil", joinColumns = {
			@JoinColumn(name = "id_utilisateur", referencedColumnName = "idUtilisateur") }, inverseJoinColumns = {
					@JoinColumn(name = "id_role", table = "role", referencedColumnName = "idRole") })
	private Set<Role> roles = new HashSet<Role>();
	@ManyToMany()
	@JoinTable(name="uti_tache", joinColumns=@JoinColumn(name="idUtilisateur"), inverseJoinColumns=@JoinColumn(name="idTache")) 
	private Set<Tache> taches=new HashSet<Tache>();
	public Utilisateur(Long idUtilisateur, String email, String nom, String prenom, Set<Tache> taches) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.taches = taches;
	}
	public Utilisateur() {
		super();
	}
	public Utilisateur(String email, String nom, String prenom, Set<Tache> taches) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.taches = taches;
	}
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Set<Tache> getTaches() {
		return taches;
	}
	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}
	
}
