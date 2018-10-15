package com.rueggerllc.productservice.test.unit;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.rueggerllc.productservice.ProductServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.MOCK,classes=ProductServiceApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("unit")
public abstract class ProductServiceUnitTest  {
}
