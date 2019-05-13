package com.adaming.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Affaire;
import com.adaming.entities.Utilisateur;
import com.adaming.service.interfaces.IAffaireService;
import com.adaming.service.interfaces.IUtilisateurService;

@Service
@Transactional
public class UtilisateurService extends ServiceGenericImp<Utilisateur> implements IUtilisateurService{

}
