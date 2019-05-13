package com.adaming.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Affaire;

import com.adaming.service.interfaces.IAffaireService;

@Service
@Transactional
public class AffaireService  extends ServiceGenericImp<Affaire> implements IAffaireService{

}
