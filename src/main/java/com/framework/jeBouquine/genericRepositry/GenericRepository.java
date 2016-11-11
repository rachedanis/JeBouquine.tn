package com.framework.jeBouquine.genericRepositry;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<T, PK extends Serializable> {

	
	public abstract T create(T object_in);
	public abstract T findByID(PK id);
	public abstract List<T> findAll();
	public abstract void update(T object_in);
	public abstract void delete(PK id);


}
