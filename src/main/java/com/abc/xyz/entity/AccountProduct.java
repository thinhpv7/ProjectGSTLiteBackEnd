package com.abc.xyz.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account_product")
@Setter
@Getter
@IdClass(AccountProductId.class)
public class AccountProduct {

	@Id
    private int product_id;
 
    @Id
    private int account_id;
    
    @Column(nullable = true)
    private int quantity;
    
//    private int productId;
    
    
    
//    private Product product;
    
//	public Product getProduct() {
//		return product;
//	}
    
//    public int getProductId() {
//		return productId;
//	}

//	@OneToMany(mappedBy = "account_product", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
//    private Set<Product> product;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id", insertable=false, updatable=false)
    private Product product1;

	public Product getProduct1() {
		return product1;
	}

//	public void setProduct1(Product product1) {
//		this.product1 = product1;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
}