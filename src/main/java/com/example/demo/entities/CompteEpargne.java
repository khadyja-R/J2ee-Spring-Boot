package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ce")
public class CompteEpargne extends Compte {
 private double taux;

public CompteEpargne() {
	super();
}

public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, double taux) {
	super(codeCompte, dateCreation, solde, client);
	this.taux = taux;
}

public double getTaux() {
	return taux;
}

public void setTaux(double taux) {
	this.taux = taux;
}
 
 
}
