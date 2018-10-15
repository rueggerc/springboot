package com.rueggerllc.productservice.test.unit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rueggerllc.productservice.beans.ProductBean;
import com.rueggerllc.productservice.repository.ProductRepository;
import com.rueggerllc.productservice.service.ProductService;

public class ProductServiceTest extends ProductServiceUnitTest {
	
	@MockBean
	private ProductRepository repoMock;
	
	@Autowired
	private ProductService service;
	
	
	@Test
	public void testControllerGetAllProducts() throws Exception {
		System.out.println("testServiceGetAllProducts BEGIN");
		
		// When
		Mockito.when(repoMock.findAll())
		.thenReturn(getMockedProducts());
		
		List<ProductBean> products = service.getAllProducts();
		for (ProductBean productBean : products) {
			System.out.println("Next Product=" + productBean.getDescription());
		}

	}
	
	private List<ProductBean> getMockedProducts() {
		List<ProductBean> products = new ArrayList<ProductBean>();
		for (int i = 0; i < 2; i++) {
			ProductBean productBean = new ProductBean();
			productBean.setProductID("P0000"+i);
			productBean.setDescription("Product" +i);
			productBean.setAmount(100+i);
			products.add(productBean);
		}
		return products;
	}
	
	

}
