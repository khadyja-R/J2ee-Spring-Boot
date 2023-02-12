package com.example.demo.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product  implements Serializable{
	
	@Id @GeneratedValue
	private Long id ;
	private String designation ;
	
	private double prix;
	private int quantitie;
	public Product() {
		super();
	}
	public Product(String designation, double prix, int quantitie) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantitie = quantitie;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantitie() {
		return quantitie;
	}
	public void setQuantitie(int quantitie) {
		this.quantitie = quantitie;
	}
	
	

}
