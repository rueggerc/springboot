package com.rueggerllc.orderservice.beans;

import java.util.List;

public class OrderResponse {
	
	private List<OrderBean> orders;
	
	public List<OrderBean> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderBean> orders) {
		this.orders = orders;
	}
	

}
