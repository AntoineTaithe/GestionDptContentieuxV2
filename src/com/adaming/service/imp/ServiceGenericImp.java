package com.adaming.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.utils.DAOGeneric;
import com.adaming.utils.ServiceGeneric;

@Service
@Transactional
public class ServiceGenericImp<T> implements ServiceGeneric<T> {
	@Autowired
	@Qualifier(value="daoGen")
	DAOGeneric<T> daoGeneric;

	public void create(T o) {
		daoGeneric.create(o);
	}

	public void update(T o) {
		daoGeneric.update(o);
	}

	public void delete(Long id) {
		daoGeneric.delete(id);
	}

	public T findOne(Class<T> o, Long id) {
		return (T) daoGeneric.findOne(o, id);
	}

	public List<T> find(Class<T> o) {
		return daoGeneric.findAll(o);
	}

}
