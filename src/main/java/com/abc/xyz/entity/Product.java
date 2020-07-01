package com.abc.xyz.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.websocket.Encoder.Binary;

import com.abc.xyz.entity.*;

@Entity
@Table(name = "product")
public class Product {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int ID;
	
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = true)
	private float price;
	
	@Column(nullable = true)
	private String name;
	
//	@Column(nullable = true)
//	private String name_picture;
	
//	@Column(nullable = true)
//	private String type;
	
	@Column(nullable = true)
	private String product_code;
	

//	@Column(nullable = true)
//    private byte[] image;
	
	private int CATEGORY_ID;
	
//	public Product() {
//		super();
//	}
	
//    public Product(int CATEGORY_ID, String description, byte[] image,  String name_picture, 
//    		float price, String product_code, String type, String name) {
//        super();
//        this.name_picture = name_picture;
//        this.image = image;
//        this.CATEGORY_ID = CATEGORY_ID;
//        this.product_code = product_code;
//        this.price = price;
//        this.description = description;
//        this.type = type;
//        this.name = name;    
//    }
    
//    public Product(int CATEGORY_ID, String description, String name, 
//    		float price, String product_code) {
//        super();
//        this.name = name;
//        this.CATEGORY_ID = CATEGORY_ID;
//        this.product_code = product_code;
//        this.price = price;
//        this.description = description;
//        this.type = type;
//        this.name = name;    
//    }
    
//    public Product(String name_picture, String type, byte[] image) {
//        this.name_picture = name_picture;
//        this.type = type;
//        this.image = image;
//	}
    
//    public Product(String name, byte[] image) {
//        super();
//        this.name = name;
//        this.image = image;
//        this.CATEGORY_ID = CATEGORY_ID;
//        this.product_code = product_code;
//        this.price = price;
//        this.description = description;
//    }
	
	public int getCATEGORY_ID() {
		return CATEGORY_ID;
	}
	
//	public String getName_picture() {
//		return name_picture;
//	}
//
//	public void setName_picture(String name_picture) {
//		this.name_picture = name_picture;
//	}

//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}

//	public byte[] getImage() {
//		return image;
//	}
//
//	public void setImage(byte[] image) {
//		this.image = image;
//	}

	public void setCATEGORY_ID(int cATEGORY_ID) {
		CATEGORY_ID = cATEGORY_ID;
	}



	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CATEGORY_ID", insertable=false, updatable=false)
    private Category category;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "cart_product",
//	        joinColumns = @JoinColumn(name = "product_id"),
//	        inverseJoinColumns = @JoinColumn(name = "cart_id"))
//	private List<Account> cart;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "account_product",
	        joinColumns = @JoinColumn(name = "product_id"),
	        inverseJoinColumns = @JoinColumn(name = "account_id"))
	private List<Account> account;

//	public void setCart(List<Account> cart) {
//		this.cart = cart;
//	}


	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

//	public List<Account> getAccount() {
//		return account;
//	}
}
