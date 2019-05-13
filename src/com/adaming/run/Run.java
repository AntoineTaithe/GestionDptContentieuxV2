package com.adaming.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.entities.*;
import com.adaming.service.interfaces.*;




public class Run {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		IUtilisateurService utilService=(IUtilisateurService) context.getBean("utilisateurService");
		Utilisateur user=new Utilisateur();
		user.setEmail("user@hotmail.fr");
		user.setNom("user");
		user.setPrenom("user");
		utilService.create(user);
//		ITacheService tacheService = (ITacheService) context.getBean("tacheService");
//		IAffaireService affaireService = (IAffaireService) context.getBean("affaireFactureService");
//		IPhaseService commercialService = (IPhaseService) context.getBean("phaseService");
//		ITribunalService tribunalService = (ITribunalService) context.getBean("tribunalService");
		
//		Tribunal tribu1= new Tribunal("Rue Gambetta",52535355535l,425532424l,"milo");
//		Tribunal tribu2= new Tribunal("Gtta",56854626l,775225885l,"dijon");
//		Tribunal tribu3= new Tribunal("Rtta",55777577576l,425886895l,"lorraine");
//		Tribunal tribu4= new Tribunal("etyilo",52522526l,75754557l,"indre");
//		tribunalService.create(tribu1);
//		tribunalService.create(tribu4);
//		tribunalService.create(tribu3);
//		tribunalService.create(tribu2);
	}

}
