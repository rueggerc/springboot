package com.rueggerllc.orderservice.tests.unit;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.rueggerllc.orderservice.service.OrderService;

@Profile("unit")
@Configuration
public class UnitTestConfiguration {
	
    @Bean
    @Primary
    public OrderService orderService() {
    	System.out.println("=========== YO RUEGGER RETURNING FAKE OrderService");
        return Mockito.mock(OrderService.class);
    }

}
