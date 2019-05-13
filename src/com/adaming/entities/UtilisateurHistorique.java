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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class UtilisateurHistorique implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUtilisateurHistorique;
	@Column(unique = true)
	private String usernameHistorique;
	private String passwordHistorique;
	private String emailHistorique;
	private String nomHistorique;
	private String prenomHistorique;
	private boolean enabled = true;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "profil", joinColumns = {
			@JoinColumn(name = "id_utilisateur", referencedColumnName = "idUtilisateurHistorique") }, inverseJoinColumns = {
					@JoinColumn(name = "id_role", table = "role", referencedColumnName = "idRoleHistorique") })
	
	private Set<RoleHistorique> rolesHistoriques = new HashSet<RoleHistorique>();
	
	@ManyToMany()
	@JoinTable(name="uti_tache", joinColumns=@JoinColumn(name="idUtilisateurHistorique"), inverseJoinColumns=@JoinColumn(name="idTacheHistorique")) 
	private Set<TacheHistorique> tachesHistorique=new HashSet<TacheHistorique>();

	
	
	public UtilisateurHistorique() {
		super();
	}

	public UtilisateurHistorique(String usernameHistorique, String passwordHistorique, String emailHistorique,
			String nomHistorique, String prenomHistorique, boolean enabled) {
		super();
		this.usernameHistorique = usernameHistorique;
		this.passwordHistorique = passwordHistorique;
		this.emailHistorique = emailHistorique;
		this.nomHistorique = nomHistorique;
		this.prenomHistorique = prenomHistorique;
		this.enabled = enabled;
	}

	public UtilisateurHistorique(String usernameHistorique, String passwordHistorique, String emailHistorique,
			String nomHistorique, String prenomHistorique, boolean enabled, Set<RoleHistorique> rolesHistoriques,
			Set<TacheHistorique> tachesHistorique) {
		super();
		this.usernameHistorique = usernameHistorique;
		this.passwordHistorique = passwordHistorique;
		this.emailHistorique = emailHistorique;
		this.nomHistorique = nomHistorique;
		this.prenomHistorique = prenomHistorique;
		this.enabled = enabled;
		this.rolesHistoriques = rolesHistoriques;
		this.tachesHistorique = tachesHistorique;
	}

	public UtilisateurHistorique(Long idUtilisateurHistorique, String usernameHistorique, String passwordHistorique,
			String emailHistorique, String nomHistorique, String prenomHistorique, boolean enabled,
			Set<RoleHistorique> rolesHistoriques, Set<TacheHistorique> tachesHistorique) {
		super();
		this.idUtilisateurHistorique = idUtilisateurHistorique;
		this.usernameHistorique = usernameHistorique;
		this.passwordHistorique = passwordHistorique;
		this.emailHistorique = emailHistorique;
		this.nomHistorique = nomHistorique;
		this.prenomHistorique = prenomHistorique;
		this.enabled = enabled;
		this.rolesHistoriques = rolesHistoriques;
		this.tachesHistorique = tachesHistorique;
	}

	
	
	public Long getIdUtilisateurHistorique() {
		return idUtilisateurHistorique;
	}
	public void setIdUtilisateurHistorique(Long idUtilisateurHistorique) {
		this.idUtilisateurHistorique = idUtilisateurHistorique;
	}

	public String getUsernameHistorique() {
		return usernameHistorique;
	}
	public void setUsernameHistorique(String usernameHistorique) {
		this.usernameHistorique = usernameHistorique;
	}

	public String getPasswordHistorique() {
		return passwordHistorique;
	}
	public void setPasswordHistorique(String passwordHistorique) {
		this.passwordHistorique = passwordHistorique;
	}
	
	public String getEmailHistorique() {
		return emailHistorique;
	}
	public void setEmailHistorique(String emailHistorique) {
		this.emailHistorique = emailHistorique;
	}

	public String getNomHistorique() {
		return nomHistorique;
	}
	public void setNomHistorique(String nomHistorique) {
		this.nomHistorique = nomHistorique;
	}

	public String getPrenomHistorique() {
		return prenomHistorique;
	}
	public void setPrenomHistorique(String prenomHistorique) {
		this.prenomHistorique = prenomHistorique;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Set<RoleHistorique> getRolesHistoriques() {
		return rolesHistoriques;
	}
	public void setRolesHistoriques(Set<RoleHistorique> rolesHistoriques) {
		this.rolesHistoriques = rolesHistoriques;
	}
	
	public Set<TacheHistorique> getTachesHistorique() {
		return tachesHistorique;
	}
	public void setTachesHistorique(Set<TacheHistorique> tachesHistorique) {
		this.tachesHistorique = tachesHistorique;
	}
	
	
	
	@Override
	public String toString() {
		return "UtilisateurHistorique [idUtilisateurHistorique=" + idUtilisateurHistorique + ", usernameHistorique="
				+ usernameHistorique + ", passwordHistorique=" + passwordHistorique + ", emailHistorique="
				+ emailHistorique + ", nomHistorique=" + nomHistorique + ", prenomHistorique=" + prenomHistorique
				+ ", enabled=" + enabled + ", rolesHistoriques=" + rolesHistoriques + ", tachesHistorique="
				+ tachesHistorique + "]";
	}
	
	
}
