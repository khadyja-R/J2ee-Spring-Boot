package com.example.demo.Service;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;

public interface IBanqueService {
	
	public Compte consulterCompte(String codecpte);
	public void verser(String codecpte, double montant);
	public void retirer(String codecpte, double montant);
	public void virement(String codecpte1, String codecpte2, double montant);
	public Page<Operation> ListOperation(String codecpte, int page , int size);

}
