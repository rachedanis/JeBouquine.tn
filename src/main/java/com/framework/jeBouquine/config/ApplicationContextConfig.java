package com.framework.jeBouquine.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

import com.framework.jeBouquine.dao.OuvrageDao;
import com.framework.jeBouquine.dao.OuvrageDaoImpl;
import com.framework.jeBouquine.entities.Auteur;
import com.framework.jeBouquine.entities.Editeur;
import com.framework.jeBouquine.entities.Ouvrage;

@Configuration
@ComponentScan("com.framework.*")
@EnableTransactionManagement
@EnableWebMvc
public class ApplicationContextConfig {
	


	// hibernate beans

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jebouquinedb");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		return  dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return properties;
	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getDataSource());
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Ouvrage.class);
		sessionBuilder.addAnnotatedClasses(Editeur.class);
		sessionBuilder.addAnnotatedClasses(Auteur.class);
		sessionBuilder.addAnnotatedClasses(Ouvrage.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Bean(name = "hibernateTemplate")
	public HibernateTemplate getHibernateTemplate() {

		HibernateTemplate h = new HibernateTemplate();
		h.setSessionFactory(getSessionFactory());
		return h;

	}

	@Autowired
	@Bean(name = "ouvrageDao")
	public OuvrageDao getOuvrageDao() {
		return new OuvrageDaoImpl(getSessionFactory());
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(getHibernateTemplate().getSessionFactory());

		return transactionManager;
	}

	// spring mvc beans

	@Bean(name = "viewResolver")
	public UrlBasedViewResolver getViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(org.springframework.web.servlet.view.tiles3.TilesView.class);
//		viewResolver.setPrefix("/WEB-INF/bodyFragments/");
//		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer(){
	    TilesConfigurer tilesConfigurer = new TilesConfigurer();
	    tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
	    tilesConfigurer.setCheckRefresh(true);
	    return tilesConfigurer;
	}

	
}