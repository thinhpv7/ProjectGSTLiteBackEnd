package com.abc.xyz.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.abc.xyz.entity.AccountProduct;

@Repository
public interface AccountProductRepository extends PagingAndSortingRepository<AccountProduct, Integer>{

	@Modifying
	@Transactional
	@Query("delete from AccountProduct b where b.account_id=:account_id and b.product_id=:product_id")
	int deleteCartProduct(@Param("account_id") int account_id, @Param("product_id") int product_id);
	
	@Modifying
	@Transactional
	@Query("UPDATE AccountProduct b SET b.account_id=:account_id, b.product_id=:product_id where b.account_id=:account_id and b.product_id=:product_id")
	int updateCartProduct(@Param("account_id") int MAMH_ID, @Param("product_id") int product_id);
}
