package com.app.raghu.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.raghu.entity.StockInfo;
import com.app.raghu.repo.StockInfoRepository;
import com.app.raghu.util.JsonUtil;

@Component
public class MessageStore {
	
	@Autowired
	private StockInfoRepository repo;

	public void add(String message) {
		//JSON TO Object
		StockInfo si = JsonUtil.convertToObj(message);
		repo.save(si);
	}

	public List<StockInfo> getAll() {
		return repo.findAll();
	}

}
