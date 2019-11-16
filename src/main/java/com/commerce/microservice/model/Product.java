package com.commerce.microservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;


//@JsonIgnoreProperties(value ="prixachat")
@Entity
public class Product {
	@Id
	@GeneratedValue
	private int id;
    @Length(min=3 , max = 20)	
	private String nomProduit;
	private int prixvente;
	private int prixachat;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String nomProduit, int prixvente, int prixachat) {

		this.id = id;
		this.nomProduit = nomProduit;
		this.prixvente = prixvente;
		this.prixachat = prixachat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public int getPrixvente() {
		return prixvente;
	}
	public void setPrixvente(int prixvente) {
		this.prixvente = prixvente;
	}
	public int getPrixachat() {
		return prixachat;
	}
	public void setPrixachat(int prixachat) {
		this.prixachat = prixachat;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", nomProduit=" + nomProduit + ", prixvente=" + prixvente + ", prixachat="
				+ prixachat + "]";
	}
	


}
