//package com.abc.xyz.repository;
//
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.abc.xyz.entity.CartProduct;
//
//@Repository
//public interface CartProductRepository  extends PagingAndSortingRepository<CartProduct, Integer>{
//	@Modifying
//	@Transactional
//	@Query("delete from CartProduct b where b.cart_id=:cart_id and b.product_id=:product_id")
//	int deleteCartProduct(@Param("cart_id") int cart_id, @Param("product_id") int product_id);
//	
//	@Modifying
//	@Transactional
//	@Query("UPDATE CartProduct b SET b.cart_id=:cart_id, b.product_id=:product_id where b.cart_id=:cart_id and b.product_id=:product_id")
//	int updateCartProduct(@Param("cart_id") int MAMH_ID, @Param("product_id") int product_id);
//}
