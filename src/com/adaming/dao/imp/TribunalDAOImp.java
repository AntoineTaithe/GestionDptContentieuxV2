package com.adaming.dao.imp;

import org.springframework.stereotype.Repository;

import com.adaming.entities.Affaire;
import com.adaming.entities.Tribunal;
import com.adaming.interfaces.IAffaireDAO;
import com.adaming.interfaces.ITribunalDAO;

@Repository
public class TribunalDAOImp extends DAOGenericImp<Tribunal> implements ITribunalDAO{

}
