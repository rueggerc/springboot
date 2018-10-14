package com.rueggerllc.orderservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rueggerllc.orderservice.beans.OrderBean;
import com.rueggerllc.orderservice.beans.OrderResponse;
import com.rueggerllc.orderservice.service.OrderService;

@RestController
@RequestMapping("/v1/order-service")
public class OrderController {
	
	private final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	public OrderController(OrderService service) {
	  this.service = service;
	}
	
	@Autowired
	private OrderService service;
	
	@RequestMapping(method=RequestMethod.GET,value="/orders",produces={"application/json"})
	public ResponseEntity<OrderResponse> getAllOrders() {
		System.out.println("ORDER CONTROLLER GET ALL ORDERS SERVICE BEFORE");
		System.out.println("Class=" + service.getClass().getName());
		List<OrderBean> orders = service.getAllOrders();
		for (OrderBean orderBean : orders) {
			System.out.println("Next ORDER=" + orderBean.getProductID());
		}
		System.out.println("ORDER CONTROLLER GET ALL ORDERS SERVICE AFTER");
		OrderResponse response = new OrderResponse();
		response.setOrders(orders);
		return new ResponseEntity<OrderResponse>(response,HttpStatus.OK);
	}

}
