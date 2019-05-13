package com.adaming.utils;

import java.util.List;

public interface ServiceGeneric<T> {
	public void create(T o);

	public void update(T o);

	public void delete(T o);

	public T findOne(Class<T> o, Long id);

	public List<T> find(Class<T> o);
}
