package com.rueggerllc.orderservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rueggerllc.orderservice.beans.OrderBean;

public interface OrderRepository extends CrudRepository<OrderBean,Long> {
	
	public OrderBean findByProductID(String productID);
	
	public Iterable<OrderBean> findByQuantity(int quantity);
	
	@Query("from Order o where o.productID=:productID")
	public Iterable<OrderBean> getFoo(@Param("productID") String productID);

}
