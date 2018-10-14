package com.rueggerllc.orderservice.tests.unit;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.annotations.Test;

import com.rueggerllc.orderservice.OrderServiceApplication;
import com.rueggerllc.orderservice.beans.OrderBean;
import com.rueggerllc.orderservice.service.OrderService;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.MOCK,classes=OrderServiceApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("unit")
public class OrderControllerTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private OrderService serviceMock;
	
	@Autowired 
	private MockMvc mvc;
	
	
	@Test
	public void testContextLoad() throws Exception {
		System.out.println("testContextLoad BEGIN");
		// Assert.assertNotNull(controller);
		System.out.println("Controller is not null");
		System.out.println("ServiceMock is " + serviceMock);
		System.out.println("testContextLoad END");
		
	}
	
	@Test
	public void testControllerGetAllOrders() throws Exception {
		
		System.out.println("GET ALL ORDERS BEGIN");
		// System.out.println("SERVICE MOCK=" + serviceMock.getClass().getName());
		
		when(serviceMock.getAllOrders())
		.thenReturn(getDummyOrders());
		
		MockHttpServletResponse response = mvc.perform(
			MockMvcRequestBuilders.get("/v1/order-service/orders")
			.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();
		
		System.out.println("GET ALL ORDERS END");
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
