package com.app.raghu;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }
    
    public List<String> getDataLen() {
        try {
            return repository.getData().stream()
                    .filter(data -> data.length() < 5)
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            return Arrays.asList();
        }
    }
}

