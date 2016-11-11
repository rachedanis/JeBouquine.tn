package com.framework.jeBouquine.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.framework.jeBouquine.entities.CompteId;
import com.framework.jeBouquine.formModel.KeyWord;

@Controller
@SessionAttributes("loginForm")
public class LoginController {
	
	@ModelAttribute("loginForm")
	public CompteId addCompteIdToSessionScope(){
		return new CompteId();
		
	}
	@ModelAttribute("searchKeyWord")
 	public KeyWord addKeyWord()
 	{
 		return new KeyWord();
 	}
	
	
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String viewLogin() {
	        return "login";
	    }
	 
	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String doLogin(@Valid @ModelAttribute("loginForm") CompteId loginForm,
	            BindingResult result,Model model) {
	 
	        if (result.hasErrors()) {
	            return "login";
	        }
	 
	        return "homePage";
	    }

}
