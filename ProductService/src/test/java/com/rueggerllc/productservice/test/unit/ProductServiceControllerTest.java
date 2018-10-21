package com.rueggerllc.productservice.test.unit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rueggerllc.productservice.beans.ProductBean;
import com.rueggerllc.productservice.service.ProductService;

public class ProductServiceControllerTest extends BaseUnitTest {

	@Autowired 
	private MockMvc mvc;
	
	@MockBean
	private ProductService serviceMock;
	
	
	@Test
	public void testControllerGetAllProducts() throws Exception {
		System.out.println("testControllerGetAllProducts BEGIN");
		
		// When
		Mockito.when(serviceMock.getAllProducts())
		.thenReturn(getMockedProducts());
		
		// Then
		MockHttpServletResponse response = mvc.perform(
			MockMvcRequestBuilders.get("/v1/product-service/products")
			.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();
		
		String content = response.getContentAsString();
		System.out.println("CONTENT=\n" + content);
		
		
	}
	
	private List<ProductBean> getMockedProducts() {
		List<ProductBean> products = new ArrayList<ProductBean>();
		for (int i = 0; i < 2; i++) {
			ProductBean productBean = new ProductBean();
			productBean.setProductID("P0000"+i);
			productBean.setDescription("Product" +i);
			productBean.setQuantity(100+i);
			products.add(productBean);
		}
		return products;
	}
	
	

}
