package com.adaming.utils;

import java.util.List;

public interface DAOGeneric<T> {
	public List<T> findAll(Class<T> o);

	public void create(T o);

	public void update(T o);

	public void delete(Long id);

	public T findOne(Class<T> o, Long id);
}
