package com.rueggerllc.orderservice.tests.unit;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rueggerllc.orderservice.OrderServiceApplication;
import com.rueggerllc.orderservice.beans.OrderBean;
import com.rueggerllc.orderservice.service.OrderService;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.MOCK,classes=OrderServiceApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("unit")
public class OrderControllerMock3Test extends AbstractTestNGSpringContextTests {

	@MockBean
	private OrderService serviceMock;
	
	@Autowired 
	private MockMvc mvc;
	
	
	@BeforeMethod(alwaysRun=true)
	public void setup() {
		System.out.println("Unit Test Setup");
		// MockitoAnnotations.initMocks(this);
		// System.out.println("ServiceMock is " + serviceMock.getClass().getName());
	}
	
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
		
		System.out.println("GET ALL ORDERS END");
		
		MockHttpServletResponse response = mvc.perform(
			MockMvcRequestBuilders.get("/v1/order-service/orders")
			.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();
		
//		System.out.println("Status=" + response.getStatus());
//		System.out.println("Response String=[" + response.getContentAsString() + "]");
//		
//		Assertions.assertThat(response.getStatus()).isEqualTo(200);
//		System.out.println("Test Passed");
		
	}
	
//	@Test
//	public void testControllerGetAllOrders2() throws Exception {
//		
//		System.out.println("HERE WE GO WITH GET ORDERS 2");
//		when(service.getAllOrders())
//		.thenReturn(getDummyOrders());
//		
//		ResultActions result = mvc.perform(
//		  get("/v1/order-service/orders")
//		  .accept(MediaType.APPLICATION_JSON))
//	      .andDo(print())
//	      .andExpect(status().isOk());
//		
//	}
	
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
	
	
	
//	@Test
//	public void testControllerSayHello() throws Exception {
//		
//		MockHttpServletResponse response = mvc.perform(
//			get("/v1/hello/sayHello")
//			.accept(MediaType.APPLICATION_JSON))
//			.andReturn().getResponse();
//		
//		System.out.println("Status=" + response.getStatus());
//		System.out.println("Response String=[" + response.getContentAsString() + "]");
//		
//		assertThat(response.getStatus()).isEqualTo(200);
//		System.out.println("Test Passed");
//		
//		
//	}

}
