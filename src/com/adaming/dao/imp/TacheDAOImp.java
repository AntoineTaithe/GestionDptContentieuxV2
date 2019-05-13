package com.adaming.dao.imp;

import org.springframework.stereotype.Repository;

import com.adaming.entities.Affaire;
import com.adaming.entities.Tache;
import com.adaming.interfaces.IAffaireDAO;
import com.adaming.interfaces.ITacheDAO;

@Repository
public class TacheDAOImp extends DAOGenericImp<Tache> implements ITacheDAO {

}
