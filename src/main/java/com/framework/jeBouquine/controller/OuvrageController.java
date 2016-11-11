package com.framework.jeBouquine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.framework.jeBouquine.dao.OuvrageDao;
import com.framework.jeBouquine.entities.Ouvrage;
@org.springframework.stereotype.Controller
public class OuvrageController  {

	@Autowired
	private OuvrageDao ouvrageDao;

	  
	@RequestMapping(value = "/1", method = RequestMethod.GET)
	public ModelAndView findById()
	{
		Ouvrage o =ouvrageDao.findById("11");
		o.setId("12");
		ouvrageDao.saveOrupdate(o);
		return new ModelAndView("redirect:/");		
	}

}
