//package com.abc.xyz.entity;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import com.abc.xyz.entity.*;
//
//@Entity
//@Table(name = "cart")
//public class Cart {
//
//	@Id 
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(nullable = false)
//	private int ID;
//	
//	@Column(nullable = true)
//	private float price;
//	
//	@Column(nullable = true)
//	private String name;
//	
//	@Column(nullable = true)
//	private String quantity;
//	
//	@ManyToMany(mappedBy="cart",fetch = FetchType.EAGER)
//	private List<Product> product;
//	
//	public int getID() {
//		return ID;
//	}
//
//	public void setID(int iD) {
//		ID = iD;
//	}
//
//	public float getPrice() {
//		return price;
//	}
//
//	public void setPrice(float price) {
//		this.price = price;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(String quantity) {
//		this.quantity = quantity;
//	}
//
//	public List<Product> getProduct() {
//		return product;
//	}
//
//	public void setProduct(List<Product> product) {
//		this.product = product;
//	}
//	
//}
