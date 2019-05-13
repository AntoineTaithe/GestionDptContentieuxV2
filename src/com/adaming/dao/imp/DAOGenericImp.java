package com.adaming.dao.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.adaming.utils.DAOGeneric;

@Repository("daoGen")
public class DAOGenericImp<T> implements DAOGeneric<T>{
@Autowired
SessionFactory sessionFactory;

	public void create(T o) {
		Session session=this.sessionFactory.getCurrentSession(); //ouverture connexion, fermeture session etc.. au lieu d'écrire begin. etc..
		session.save(o);
		
	}

	public void update(T o) {
		Session session=this.sessionFactory.getCurrentSession(); //ouverture connexion, fermeture session etc.. au lieu d'écrire begin. etc..
		session.update(o);		
	}

	public void delete(Long id) {
		Session session=this.sessionFactory.getCurrentSession(); //ouverture connexion, fermeture session etc.. au lieu d'écrire begin. etc..
		session.delete(id);		
	}

	public T findOne(Class<T> o, Long id) {
		Session session=this.sessionFactory.getCurrentSession();
		return (T) session.get(o, id);
	}

	public List<T> findAll(Class<T> o) {
		Session session=this.sessionFactory.getCurrentSession();	
		Criteria crit=session.createCriteria(o);
		return crit.list();
	}


}
