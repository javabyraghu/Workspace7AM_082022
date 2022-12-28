package com.app.raghu;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

	private Repository repo;

	public Service(Repository repo) {
		this.repo = repo;
	}

	public List<String> getDataByLen() {
		try {
			return repo.getData().stream()
					.filter(d -> d.length() < 5)
					.collect(Collectors.toList());
		} catch (SQLException e) {
			return Arrays.asList();
		}
		
	}
}
