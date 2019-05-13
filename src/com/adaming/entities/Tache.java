package com.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Tache implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTache;
	@Temporal(value=TemporalType.DATE)
	private Date dateCreation;
	private String description;
	private String titre;
	private boolean StatutAudience;
	@ManyToOne
	private Affaire affaire;
	@ManyToOne
	private Tribunal tribunal;
	@OneToMany(mappedBy="tache")
	private Set<Phase>phases=new HashSet<Phase>();
	public Tache(Long idTache, Date dateCreation, String description, String titre, boolean statutAudience,
			Affaire affaire, Tribunal tribunal, Set<Phase> phases) {
		super();
		this.idTache = idTache;
		this.dateCreation = dateCreation;
		this.description = description;
		this.titre = titre;
		StatutAudience = statutAudience;
		this.affaire = affaire;
		this.tribunal = tribunal;
		this.phases = phases;
	}
	public Tache() {
		super();
	}
	public Long getIdTache() {
		return idTache;
	}
	public void setIdTache(Long idTache) {
		this.idTache = idTache;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public boolean isStatutAudience() {
		return StatutAudience;
	}
	public void setStatutAudience(boolean statutAudience) {
		StatutAudience = statutAudience;
	}
	public Affaire getAffaire() {
		return affaire;
	}
	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}
	public Tribunal getTribunal() {
		return tribunal;
	}
	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}
	public Set<Phase> getPhases() {
		return phases;
	}
	public void setPhases(Set<Phase> phases) {
		this.phases = phases;
	}
	
}
