package com.framework.jeBouquine.dao;

import java.util.Collection;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.framework.jeBouquine.entities.Auteur;
import com.framework.jeBouquine.entities.Ouvrage;


@Repository
@Transactional
public class OuvrageDaoImpl   implements OuvrageDao {
	@Autowired
	SessionFactory sessionFactory;
	Criteria criteria ;
	org.hibernate.Transaction transaction;
	public OuvrageDaoImpl(){
		
	}

	public OuvrageDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly=false)
	@Override
	public Ouvrage findById(String id) {
		// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().setFlushMode(FlushMode.COMMIT);
		transaction =  sessionFactory.getCurrentSession().beginTransaction();
		criteria=sessionFactory.getCurrentSession().createCriteria(Ouvrage.class);
		criteria.add(Restrictions.eq("id",id));
		Ouvrage ouvrage = (Ouvrage)criteria.list().get(0);
		transaction.commit();
		
		if(ouvrage!=null)
		return ouvrage;
		else return null;
		
		
	}


	@Transactional
	@Override
	public void saveOrupdate(Ouvrage ouvrage) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(ouvrage);

	}

	@Override
	public void delete(Ouvrage ouvrage) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(ouvrage);
		
	}

	@Override
	public Collection<Ouvrage> findByCategorie(String categorie) {
		// TODO Auto-generated method stub
		criteria=sessionFactory.getCurrentSession().createCriteria(Ouvrage.class);
		criteria.add(Restrictions.eq("categorie",categorie));
		
			return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Ouvrage> findByAutheur(String autheur) {
		// TODO Auto-generated method stub
		org.hibernate.Query query =(org.hibernate.Query) sessionFactory.getCurrentSession().createQuery("select * from ouvrage");
		
		Vector<Ouvrage> ouvrages = new Vector<Ouvrage>();
		ouvrages=(Vector<Ouvrage>) query.list();
		boolean test =false;
		for(int i=0;i<ouvrages.size();i++){
			for(int j=0;j<ouvrages.get(i).getAuteur().size();j++){
				if(((Vector<Auteur>)ouvrages.get(i).getAuteur()).get(i).getNom().equals(autheur))
					test=true;
				
			}
			if(!test)
				ouvrages.remove(ouvrages.get(i));
			else test=false;
				
				
			
		}
		
			return ouvrages;
	}

	@Override
	public Collection<Ouvrage> findByTitre(String titre) {
		// TODO Auto-generated method stub
		criteria=sessionFactory.getCurrentSession().createCriteria(Ouvrage.class);
		criteria.add(Restrictions.eq("nom",titre));
		
			return criteria.list();
	}

	@Override
	public Collection<Ouvrage> findByKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		criteria=sessionFactory.getCurrentSession().createCriteria(Ouvrage.class);
		criteria.add(Restrictions.like("nom",keyWord,MatchMode.ANYWHERE));
		
			return criteria.list();
		
	}

}
