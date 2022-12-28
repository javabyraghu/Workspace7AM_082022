package com.app.raghu.consumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@Component
public class CartConsumerOld {

	//Impl class is : EurekaDiscoveryClient -- given by Netflix Eureka
	@Autowired
	private DiscoveryClient client;

	public String getCartResponse() {
		// Goto Eureka server with serviceId
		List<ServiceInstance> list = client.getInstances("CART-SERVICE");

		// read at index#0 ==> returns SI
		ServiceInstance si = list.get(0);

		// read URI
		URI uri = si.getUri();

		// add path ==> return URL
		String url = uri + "/cart/info";

		// use RestTemplate and call
		RestTemplate rt = new RestTemplate();
		
		//make HTTP Request and get response
		ResponseEntity<String> response = rt.getForEntity(url, String.class);

		//return response body
		return response.getBody();
	}
}
