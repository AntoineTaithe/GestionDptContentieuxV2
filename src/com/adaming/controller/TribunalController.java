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

import com.adaming.entities.Tribunal;

import com.adaming.entities.Tribunal;
import com.adaming.entities.Tribunal;
import com.adaming.service.interfaces.ITribunalService;

//pour dire que n'importe quel port peut se connecter avec le port 8080
@RestController
public class TribunalController {
	@Autowired
	ITribunalService tribunalService;

	
	
	@RequestMapping(value = "tribunals", method = RequestMethod.GET)
	public List<Tribunal> findAll(Class<Tribunal> o) {
		return tribunalService.find(Tribunal.class);
	}
	

	@RequestMapping(value = "tribunals/{id}", method = RequestMethod.GET)
	public Tribunal findOne(Class<Tribunal> o, @PathVariable("id") Long id) {
		return tribunalService.findOne(Tribunal.class,id);
	}

	@RequestMapping(value = "tribunals", method = RequestMethod.POST)
	public void saveTribunal(@RequestBody Tribunal tribunal) {
	tribunalService.create(tribunal);
	
	} 
	
	@RequestMapping(value = "tribunals/{id}", method = RequestMethod.DELETE)
	public void deleteTribunal(@RequestBody Class<Tribunal> tribunal, @PathVariable("id")Long id) {
	Tribunal t1= tribunalService.findOne(Tribunal.class, id);
	tribunalService.delete(t1); 
	}

	@RequestMapping(value = "tribunals/{id}", method = RequestMethod.PUT)
	public void updateTribunal(@RequestBody Tribunal tribunal, @PathVariable("id") Long id) {
		Tribunal currentTribunal = tribunalService.findOne(Tribunal.class, id);
		currentTribunal.setAdresse(tribunal.getAdresse());
		currentTribunal.setFax(tribunal.getFax());
		currentTribunal.setTel(tribunal.getTel());
		currentTribunal.setRegion(tribunal.getRegion());
		
		
		tribunalService.create(currentTribunal);
		
		
	}
}
