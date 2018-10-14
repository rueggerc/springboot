package com.rueggerllc.productservice.test.unit;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.rueggerllc.productservice.ProductServiceApplication;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.MOCK,classes=ProductServiceApplication.class)
//@AutoConfigureMockMvc
@ActiveProfiles("unit")
public class ProductControllerTest  {

//	@Autowired 
//	private MockMvc mvc;
//	
	
	@Test
	public void testContextLoad() throws Exception {
		System.out.println("testContextLoad BEGIN");
		System.out.println("testContextLoad END");
		
	}

}
