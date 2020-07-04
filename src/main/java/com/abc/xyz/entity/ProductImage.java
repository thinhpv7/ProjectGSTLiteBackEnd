package com.abc.xyz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "product_image")
public class ProductImage {
//	@Id 
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(nullable = false)
//	private int ID;
//	
//	@Column(nullable = true)
//	private byte[] image;
//	
////	private int product_id;
//	
////	@ManyToOne(fetch = FetchType.EAGER)
////    @JoinColumn(name="product_id", insertable=false, updatable=false)
////    private Product product2;
//
//	public int getID() {
//		return ID;
//	}
//
//	public void setID(int iD) {
//		ID = iD;
//	}
//
//	public byte[] getImage() {
//		return image;
//	}
//
//	public void setImage(byte[] image) {
//		this.image = image;
//	}
//
//	public int getProduct_id() {
//		return product_id;
//	}

//	public void setProduct_id(int product_id) {
//		this.product_id = product_id;
//	}
//
//	public void setProduct2(Product product2) {
//		this.product2 = product2;
//	}
	
	private String name;
	  private String url;

	  public ProductImage(String name, String url) {
	    this.name = name;
	    this.url = url;
	  }

	  public String getName() {
	    return this.name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getUrl() {
	    return this.url;
	  }

	  public void setUrl(String url) {
	    this.url = url;
	  }
}
