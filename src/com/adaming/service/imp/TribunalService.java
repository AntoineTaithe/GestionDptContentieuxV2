package com.adaming.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Affaire;
import com.adaming.entities.Tribunal;
import com.adaming.service.interfaces.IAffaireService;
import com.adaming.service.interfaces.ITribunalService;

@Service
@Transactional
public class TribunalService extends ServiceGenericImp<Tribunal> implements ITribunalService{

}
