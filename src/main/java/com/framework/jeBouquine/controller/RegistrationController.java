package com.framework.jeBouquine.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framework.jeBouquine.entities.Compte;
import com.framework.jeBouquine.entities.CompteId;
import com.framework.jeBouquine.formModel.KeyWord;

@Controller

public class RegistrationController {

	@ModelAttribute("register1Form")
	public Compte addCompte() {
		return new Compte();
	}

	@ModelAttribute("register2Form")
	public CompteId addCompteId() {
		return new CompteId();
	}
	@ModelAttribute("searchKeyWord")
 	public KeyWord addKeyWord()
 	{
 		return new KeyWord();
 	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {

		return "register1";
	}

	@RequestMapping(value = "/register1", method = RequestMethod.POST)
	public String doRegister1(@Valid @ModelAttribute("register1Form") Compte register1Form, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "register1";
		}

		return "register2";
	}

	@RequestMapping(value = "/register2", method = RequestMethod.POST)
	public String doRegester2(@Valid @ModelAttribute("register2Form") CompteId register2Form, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "register2";
		}

		return "homePage";
	}

}
