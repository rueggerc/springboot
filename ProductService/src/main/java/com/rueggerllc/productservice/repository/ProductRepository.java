package com.rueggerllc.productservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rueggerllc.productservice.beans.ProductBean;

public interface ProductRepository extends CrudRepository<ProductBean,Long> {
	
	public ProductBean findByProductID(String productID);
	
	public Iterable<ProductBean> findByQuantity(int quantity);
	
	@Query("from Product p where p.productID=:productID")
	public Iterable<ProductBean> getFoo(@Param("productID") String productID);

}
