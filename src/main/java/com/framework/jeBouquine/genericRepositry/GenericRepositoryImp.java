package com.framework.jeBouquine.genericRepositry;

import java.io.Serializable;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public abstract class GenericRepositoryImp<T, PK extends Serializable> implements GenericRepository<T, PK> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> persistentClass;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public GenericRepositoryImp(Class<T> type) {
		this.persistentClass = type;
	}
	public GenericRepositoryImp() {
		
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	// @SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> toExport = null;

		Query q = getSession().createQuery("from " + persistentClass.getSimpleName());
		toExport = (List<T>) q.list();

		return toExport;
	}

	// @SuppressWarnings("unchecked")
	public T findByID(PK id) {
		T entity = null;
		entity = (T) getSession().load(persistentClass, id);

		return entity;
	}

	public T create(T object_in) {
		getSession().save(object_in);
		return object_in;
	}

	// @SuppressWarnings("unchecked")
	public void delete(PK id) {

		T a_supprimer = (T) getSession().get(persistentClass, id);
		getSession().delete(a_supprimer);

	}

	public void update(T object_in) {
		getSession().update(object_in);

	}
}