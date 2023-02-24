package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Product;


//@CrossOrigin(origins = "http://localhost:3000")
@Controller

public class ProduitController {

	@Autowired
	  private ProduitRepository produitrepo;
	  
	@RequestMapping(value="/index")
	  public String index(Model model,@RequestParam(name="page",defaultValue="0")int p ,
			  @RequestParam(name="size",defaultValue="5")int s,
			  @RequestParam(name="mc", defaultValue="")
	              String mc){
		PageRequest pageRequest = PageRequest.of(p, s);
		Page<Product> pageproduits = produitrepo.chercher("%"+mc+"%", pageRequest);
		  model.addAttribute("listproduits",pageproduits.getContent());
		  int[] pages = new int[pageproduits.getTotalPages()];
		  model.addAttribute("pages",pages);
		  model.addAttribute("size",s);
		  model.addAttribute("pagecourant",p);
		  model.addAttribute("mc",mc);
		  return "produits";
		  
		 
	  }
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	
	 public String delete(Product id, String mc, int page , int size) {
		  produitrepo.delete(id);
		  
		  return "redirect:/index?page="+page+"&size="+size+"&mc="+mc;
	  }
}
