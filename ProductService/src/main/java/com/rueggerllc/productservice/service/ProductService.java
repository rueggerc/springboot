package com.rueggerllc.productservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rueggerllc.productservice.beans.ProductBean;
import com.rueggerllc.productservice.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	// GET all Orders
	public List<ProductBean> getAllProducts() {
		List<ProductBean> products = new ArrayList<ProductBean>();
		Iterable<ProductBean> productIterator = repo.findAll();
		for (ProductBean next : productIterator) {
			products.add(next);
		}
		return products;
	}
	
	// GET Foo
	public List<ProductBean> getFoo(String productID) {
		List<ProductBean> products = new ArrayList<ProductBean>();
		Iterable<ProductBean> productIterator = repo.getFoo(productID);
		for (ProductBean next : productIterator) {
			products.add(next);
		}
		return products;
	}

}
