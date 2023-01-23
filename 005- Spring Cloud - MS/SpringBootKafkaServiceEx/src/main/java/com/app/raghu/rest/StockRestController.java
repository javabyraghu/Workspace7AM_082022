package com.app.raghu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.db.MessageStore;
import com.app.raghu.entity.StockInfo;
import com.app.raghu.service.ProducerService;
import com.app.raghu.util.JsonUtil;

@RestController
@RequestMapping("/api/v1/kafka")
public class StockRestController {
	
	@Autowired
	private ProducerService service;
	
	@Autowired
	private MessageStore store;

	//send?code=__&cost=__
	@GetMapping("/send")
	public String readMessage(
			@RequestParam String code,
			@RequestParam Double cost
			) 
	{
		//create Entity class object
		StockInfo si = new StockInfo();
		si.setStkCode(code);
		si.setStkCost(cost);
		
		//convert to JSON
		String message = JsonUtil.convertToString(si);
		
		//call producer service
		service.sendMessage(message);
		
		return "SENT";
	}
	
	@GetMapping("/all")
	public List<StockInfo> fetchAll() {
		return store.getAll();
	}
	
	
}
