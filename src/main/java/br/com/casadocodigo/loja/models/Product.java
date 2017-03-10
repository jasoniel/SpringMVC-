package br.com.casadocodigo.loja.models;

import java.util.ArrayList;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import java.util.List;

@Entity
public class Product {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@Lob
	private String description;
	private int pages;
	
	
	public String getTitle() {
		return title;
	}
	
	@ElementCollection
	private List <Price> prices = new ArrayList<Price>();
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.title;
	}
	public List <Price> getPrices() {
		return prices;
	}
	public void setPrices(List <Price> prices) {
		this.prices = prices;
	}
	
}
