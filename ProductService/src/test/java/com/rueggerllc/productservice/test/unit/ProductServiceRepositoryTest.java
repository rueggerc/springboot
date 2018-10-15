package com.rueggerllc.productservice.test.unit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.rueggerllc.productservice.beans.ProductBean;
import com.rueggerllc.productservice.repository.ProductRepository;

@DataJpaTest
public class ProductServiceRepositoryTest extends ProductServiceUnitTest {
	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void testProductRepository() throws Exception {
		System.out.println("testProductRepository BEGIN");
		
		// Given
		ProductBean newProductBean = new ProductBean();
		newProductBean.setDescription("Product 5");
		newProductBean.setProductID("P00005");
		newProductBean.setQuantity(5);
		entityManager.persist(newProductBean);
		entityManager.flush();
		
		
		// When
		Iterable<ProductBean> allProductsIterator = productRepository.findAll();
		List<ProductBean> allProducts = new ArrayList<ProductBean>();
		allProductsIterator.forEach(allProducts::add);
		
		// Then
		Assert.assertEquals(allProducts.size(),1);
		for (ProductBean productBean : allProducts) {
			System.out.println("Next Product=" + productBean.getDescription());
		}
		System.out.println("testProductRepository END");

	}
	


}
