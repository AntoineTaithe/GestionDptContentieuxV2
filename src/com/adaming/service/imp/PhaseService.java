package com.adaming.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Affaire;
import com.adaming.entities.Phase;
import com.adaming.service.interfaces.IAffaireService;
import com.adaming.service.interfaces.IPhaseService;

@Service
@Transactional
public class PhaseService extends ServiceGenericImp<Phase> implements IPhaseService{ 

}
