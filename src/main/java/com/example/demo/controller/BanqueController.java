package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.IBanqueService;
import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;

@Controller
public class BanqueController {

	@Autowired
	private IBanqueService banqueservice;
	
	
	@RequestMapping("/operations")
	public String index() {
		return "comptes";
	}
	
	
	@RequestMapping("/consulterCompte")
	
	public String consulterCompte(Model model, String codeCompte) {
		
		model.addAttribute("codeCompte",codeCompte);
		
		
		try {
			
			Compte cp = banqueservice.consulterCompte(codeCompte);
		Page<Operation>  pageOperations = 	banqueservice.ListOperation(codeCompte, 0, 4);
			
			model.addAttribute("listOperation", pageOperations.getContent());
			model.addAttribute("compte",cp);
			
		}catch(Exception e) {
			model.addAttribute("exception",e);
		}
		return "comptes";
		
	}
}
