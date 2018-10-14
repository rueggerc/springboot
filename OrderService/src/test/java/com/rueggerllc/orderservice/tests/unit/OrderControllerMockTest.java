package com.rueggerllc.orderservice.tests.unit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.Test;

import com.rueggerllc.orderservice.beans.OrderBean;
import com.rueggerllc.orderservice.controller.OrderController;
import com.rueggerllc.orderservice.service.OrderService;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("unit")
// @WebMvcTest(OrderController.class)
public class OrderControllerMockTest extends AbstractTestNGSpringContextTests {

	@Autowired 
	private MockMvc mvc;
	
	@MockBean
	private OrderService serviceMock;
	
    @Configuration
    @Import(OrderController.class) // A @Component injected with ExampleService
    static class Config {
    }
	
	
	@Test
	public void testControllerGetAllOrders() throws Exception {
		
		System.out.println("GET ALL ORDERS BEGIN");
		// System.out.println("SERVICE MOCK=" + serviceMock.getClass().getName());
		System.out.println("serviceMock=" + serviceMock);

		
//		when(serviceMock.getAllOrders())
//		.thenReturn(getDummyOrders());
//		
//		System.out.println("GET ALL ORDERS END");
//		
//		MockHttpServletResponse response = mvc.perform(
//			MockMvcRequestBuilders.get("/v1/order-service/orders")
//			.accept(MediaType.APPLICATION_JSON))
//			.andReturn().getResponse();
	}
		

	
	public List<OrderBean> getDummyOrders() {
		System.out.println("====== BUILD DUMMY ORDERS=====");
		List<OrderBean> orders = new ArrayList<OrderBean>();
		for (int i = 0; i < 2; i++) {
			OrderBean orderBean = new OrderBean();
			orderBean.setProductID("Product" + i);
			orderBean.setAmount(BigDecimal.valueOf(42.55).add(BigDecimal.valueOf(i)));
			orderBean.setDateOrdered(new Date(System.currentTimeMillis()));
			orderBean.setQuantity(100+i);
			System.out.println("ADDING DUMMY ORDER");
			orders.add(orderBean);
		}
		return orders;
	}
	


}
