package com.framework.jeBouquine.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framework.jeBouquine.dao.OuvrageDao;
import com.framework.jeBouquine.formModel.KeyWord;
import com.framework.jeBouquine.formModel.guidedResearchFrom;

@Controller
public class SearchController {
	
	@ModelAttribute("guidedResearchForm")
	public guidedResearchFrom add(){
		
		return new guidedResearchFrom();
	}
	@ModelAttribute("searchKeyWord")
 	public KeyWord addKeyWord()
 	{
 		return new KeyWord();
 	}
	
	  @RequestMapping(value = "/guidedResearch", method = RequestMethod.GET)
	    public String goToForm(Model model) {
	 
	 
	        return "guidedResearch";
	    }
	
	 
			
	    @RequestMapping(value = "/guidedResearch", method = RequestMethod.POST)
	    public String getOuvrage( @ModelAttribute("guidedResearchForm") guidedResearchFrom Form,Model model) {
	 
	    	
	        return "listRechercheCritere";
	    }

}
