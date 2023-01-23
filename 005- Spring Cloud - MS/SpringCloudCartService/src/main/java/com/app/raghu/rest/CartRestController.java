package com.app.raghu.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.entity.Cart;

@RestController
@RequestMapping("/cart")
@RefreshScope
public class CartRestController {
	
	@Value("${my.app.title}")
	private String title;

	@GetMapping("/info")
	public ResponseEntity<String> showMessage(
			@RequestHeader("MyToken") String token 
			)
	{
		return ResponseEntity.ok("WELCOME TO CART SERVICE =>" + token);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable("id")Integer id) {
		Cart cart = new Cart();
		cart.setCartId(id);
		cart.setCartCost(2300.0);
		cart.setCartCode("TEST");
		return ResponseEntity.ok(cart);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> addToCart(@RequestBody Cart cart) {
		return ResponseEntity.ok("ADDED TO CART => " + cart);
	}
}
