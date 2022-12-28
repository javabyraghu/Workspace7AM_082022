package com.app.raghu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	//1. Fetch Resource
	//@RequestMapping(value = "/fetch",method = RequestMethod.GET)
	@GetMapping("/fetch")
	public ResponseEntity<String> getProduct() {
		ResponseEntity<String> response = new ResponseEntity<>(
				"FROM GET OPERATION",  //body
				HttpStatus.OK);        //status (OK/200)
		
		return response;
	}
	
	
	//2. Create Resource
	@PostMapping("/save")
	public ResponseEntity<String> createProduct() {
		ResponseEntity<String> response = new ResponseEntity<>(
				"FROM POST OPERATION",
				HttpStatus.OK
				);
		return response;
	}
	
	
	//3. Modify Resource
	@PutMapping("/update")
	public ResponseEntity<String> updateProduct() {
		ResponseEntity<String> response = new ResponseEntity<>(
				"FROM PUT OPERATION",
				HttpStatus.OK
				);
		return response;
	}
	
	//4. Remove Resource
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteProduct() {
		ResponseEntity<String> response = new ResponseEntity<>(
				"FROM DELETE OPERATION",
				HttpStatus.OK
				);
		return response;
	}
	
	
	//5. Partial Update of Resource
	@PatchMapping("/updatecost")
	public ResponseEntity<String> modifyProductCost() {
		ResponseEntity<String> response = new ResponseEntity<>(
				"FROM PATCH OPERATION",
				HttpStatus.OK
				);
		return response;
	}
	
	
}
