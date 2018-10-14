package com.rueggerllc.productservice.beans;

import java.util.List;

public class ProductResponse {
	
	private List<ProductBean> orders;
	
	public List<ProductBean> getOrders() {
		return orders;
	}

	public void setOrders(List<ProductBean> orders) {
		this.orders = orders;
	}
	

}
