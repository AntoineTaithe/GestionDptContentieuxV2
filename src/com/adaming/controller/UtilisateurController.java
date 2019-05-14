package com.adaming.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Affaire;

import com.adaming.entities.Utilisateur;
import com.adaming.entities.Tribunal;
import com.adaming.service.interfaces.IUtilisateurService;

//pour dire que n'importe quel port peut se connecter avec le port 8080
@RestController
public class UtilisateurController {
	@Autowired
	IUtilisateurService utilisateurService;

	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<Utilisateur> findAll(Class<Utilisateur> o) {
		return utilisateurService.find(Utilisateur.class);
	}
	

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public Utilisateur findOne(Class<Utilisateur> o, @PathVariable("id") Long id) {
		return utilisateurService.findOne(Utilisateur.class,id);
	}

	@RequestMapping(value = "users", method = RequestMethod.POST)
	public void saveUtilisateur(@RequestBody Utilisateur utilisateur) {
	utilisateurService.create(utilisateur);
	
	} 
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@RequestBody Class<Utilisateur> utilisateur, @PathVariable("id")Long id) {
	Utilisateur t1= utilisateurService.findOne(Utilisateur.class, id);
	utilisateurService.delete(t1); 
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
	public void updateUtilisateur(@RequestBody Utilisateur utilisateur, @PathVariable("id") Long id) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(Utilisateur.class, id);
		currentUtilisateur.setUsername(utilisateur.getUsername());
		currentUtilisateur.setPassword(utilisateur.getPassword());
		currentUtilisateur.setEmail(utilisateur.getEmail());
		currentUtilisateur.setNom(utilisateur.getNom());
		currentUtilisateur.setPrenom(utilisateur.getPrenom());
		
		
		utilisateurService.create(currentUtilisateur);
		
		
	}
}
