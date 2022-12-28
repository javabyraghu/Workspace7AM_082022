package com.app.raghu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.consumer.CatConsumerFeign;
import com.app.raghu.entity.Cart;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	
	@Autowired
	private CatConsumerFeign consumer;
	
	@GetMapping("/place")
	public ResponseEntity<String> placeOrder() {
		String cartResp = consumer.showMessage().getBody();
		return ResponseEntity.ok("ORDER PLACED WITH => " + cartResp);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<String> fetchOrderWithCart(
			@PathVariable("id") Integer id
			) 
	{
		Cart cob = consumer.getCartById(id).getBody();
		return ResponseEntity.ok("ORDER WITH CART DATA => " + cob);
	}

	@PostMapping("/addToCart")
	public ResponseEntity<String> addToCart(
			@RequestBody Cart cart
			) 
	{
		String cartResp = consumer.addToCart(cart).getBody();
		return ResponseEntity.ok("ORDER WITH => " + cartResp);
	}
}
