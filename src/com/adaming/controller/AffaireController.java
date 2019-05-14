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

import com.adaming.entities.Affaire;
import com.adaming.entities.Tribunal;
import com.adaming.service.interfaces.IAffaireService;

//pour dire que n'importe quel port peut se connecter avec le port 8080
@RestController
public class AffaireController {
	@Autowired
	IAffaireService affaireService;

	
	
	@RequestMapping(value = "affaires", method = RequestMethod.GET)
	public List<Affaire> findAll(Class<Affaire> o) {
		return affaireService.find(Affaire.class);
	}
	

	@RequestMapping(value = "affaires/{id}", method = RequestMethod.GET)
	public Affaire findOne(Class<Affaire> o, @PathVariable("id") Long id) {
		return affaireService.findOne(Affaire.class,id);
	}

	@RequestMapping(value = "affaires", method = RequestMethod.POST)
	public void saveAffaire(@RequestBody Affaire affaire) {
	affaireService.create(affaire);
	
	} 
	
	@RequestMapping(value = "affaires/{id}", method = RequestMethod.DELETE)
	public void deleteAffaire(@RequestBody Class<Affaire> affaire, @PathVariable("id")Long id) {
	Affaire t1= affaireService.findOne(Affaire.class, id);
	affaireService.delete(t1); 
	}

	@RequestMapping(value = "affaires/{id}", method = RequestMethod.PUT)
	public void updateAffaire(@RequestBody Affaire affaire, @PathVariable("id") Long id) {
		Affaire currentAffaire = affaireService.findOne(Affaire.class, id);
		currentAffaire.setReference(affaire.getReference());
		currentAffaire.setTitre(affaire.getTitre());
		currentAffaire.setDescription(affaire.getDescription());
		
		
		affaireService.create(currentAffaire);
		
		
	}
}
