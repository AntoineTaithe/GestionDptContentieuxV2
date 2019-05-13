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


import com.adaming.entities.Affaire;

import com.adaming.entities.Tache;
import com.adaming.entities.Tribunal;
import com.adaming.service.interfaces.ITacheService;

//pour dire que n'importe quel port peut se connecter avec le port 8080
@Controller
public class TâcheController {
	@Autowired
	ITacheService tacheService;

	
	
	@RequestMapping(value = "taches", method = RequestMethod.GET)
	public List<Tache> findAll(Class<Tache> o) {
		return tacheService.find(Tache.class);
	}
	

	@RequestMapping(value = "taches/{id}", method = RequestMethod.GET)
	public Tache findOne(Class<Tache> o, @PathVariable("id") Long id) {
		return tacheService.findOne(Tache.class,id);
	}

	@RequestMapping(value = "taches", method = RequestMethod.POST)
	public void saveTache(@RequestBody Tache tache) {
	tacheService.create(tache);
	
	} 
	
	@RequestMapping(value = "taches/{id}", method = RequestMethod.DELETE)
	public void deleteTache(@RequestBody Class<Tache> tache, @PathVariable("id")Long id) {
	Tache t1= tacheService.findOne(Tache.class, id);
	tacheService.delete(t1); 
	}

	@RequestMapping(value = "taches/{id}", method = RequestMethod.PUT)
	public void updateTache(@RequestBody Tache tache, @PathVariable("id") Long id) {
		Tache currentTache = tacheService.findOne(Tache.class, id);
		currentTache.setDateCreation(tache.getDateCreation());
		currentTache.setDescription(tache.getDescription());
		currentTache.setTitre(tache.getTitre());
		currentTache.setStatutAudience(tache.isStatutAudience());
		currentTache.setDateCreation(tache.getDateCreation());
		currentTache.setDescription(tache.getDescription());
		
		tacheService.create(currentTache);
		
		
	}
}
