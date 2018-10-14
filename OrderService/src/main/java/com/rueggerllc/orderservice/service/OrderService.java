package com.rueggerllc.orderservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rueggerllc.orderservice.beans.OrderBean;
import com.rueggerllc.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	// GET all Orders
	public List<OrderBean> getAllOrders() {
		List<OrderBean> orders = new ArrayList<OrderBean>();
		Iterable<OrderBean> orderIterator = repo.findAll();
		for (OrderBean next : orderIterator) {
			orders.add(next);
		}
		return orders;
	}
	
	// GET Foo
	public List<OrderBean> getFoo(String productID) {
		List<OrderBean> orders = new ArrayList<OrderBean>();
		Iterable<OrderBean> orderIterator = repo.getFoo(productID);
		for (OrderBean next : orderIterator) {
			orders.add(next);
		}
		return orders;
	}

}
