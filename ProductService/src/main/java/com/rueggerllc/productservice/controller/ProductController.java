package com.rueggerllc.productservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rueggerllc.productservice.beans.ProductBean;
import com.rueggerllc.productservice.beans.ProductResponse;
import com.rueggerllc.productservice.service.ProductService;

@RestController
@RequestMapping("/v1/product-service")
public class ProductController {
	
	private final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	public ProductController(ProductService service) {
	  this.service = service;
	}
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(method=RequestMethod.GET,value="/products",produces={"application/json"})
	public ResponseEntity<ProductResponse> getAllOrders() {
		System.out.println("PRODUCT CONTROLLER GET ALL PRODUCTS SERVICE BEFORE");
		
		String[] profiles = environment.getActiveProfiles();
		for (String profile : profiles) {
			System.out.println("ACTIVE PROFILE=" + profile);
		}
		
		
		
		List<ProductBean> orders = service.getAllProducts();
		for (ProductBean orderBean : orders) {
			System.out.println("Next PRODUCT=" + orderBean.getProductID());
		}
		System.out.println("PRODUCT CONTROLLER GET ALL PRODUCTS SERVICE AFTER");
		ProductResponse response = new ProductResponse();
		response.setOrders(orders);
		return new ResponseEntity<ProductResponse>(response,HttpStatus.OK);
	}

}
