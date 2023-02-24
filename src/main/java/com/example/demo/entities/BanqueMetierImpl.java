package com.example.demo.entities;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Service.IBanqueService;
import com.example.demo.dao.CompteRepository;
import com.example.demo.dao.OperationRepository;
@Service
@Transactional
public class BanqueMetierImpl  implements IBanqueService{

	@Autowired
	private CompteRepository compterepository;
	private OperationRepository operationrepository;
	@Override
	public Compte consulterCompte(String codecpte) {
		Compte cp = compterepository.findById(codecpte).orElse(null);
		if(cp==null) throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public void verser(String codecpte, double montant) {
		Compte cp = consulterCompte(codecpte);
		Versement v = new Versement(new Date(), montant, cp);
		operationrepository.save(v);
		cp.setSolde(cp.getSolde()+montant);
		compterepository.save(cp);
		
		
		
	}

	@Override
	public void retirer(String codecpte, double montant) {
		Compte cp = consulterCompte(codecpte);
		double facilitesCaisse=0;
		if(cp instanceof CompteCourant)
			facilitesCaisse= ((CompteCourant) cp).getDecouvert();
		if(cp.getSolde()+facilitesCaisse < montant) {
		    throw new RuntimeException("solde insuffisant");
		}
		Retrait r = new Retrait(new Date(), montant, cp);
		operationrepository.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compterepository.save(cp);
	}

	@Override
	public void virement(String codecpte1, String codecpte2, double montant) {
		retirer(codecpte1, montant);
		verser(codecpte2, montant);
		
	}

	@Override
	public Page<Operation> ListOperation(String codecpte, int page, int size) {
	    return operationrepository.listOperation(codecpte, PageRequest.of(page, size));
	}

}
