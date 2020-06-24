package com.abc.xyz.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cart_product")
@Setter
@Getter
@IdClass(CartProductId.class)
public class CartProduct {

	@Id
    private int product_id;
 
    @Id
    private Integer cart_id;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Integer getCart_id() {
		return cart_id;
	}

	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}
    
}
