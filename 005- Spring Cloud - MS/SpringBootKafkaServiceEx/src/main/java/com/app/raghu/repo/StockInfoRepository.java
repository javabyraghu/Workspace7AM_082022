package com.app.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.entity.StockInfo;

public interface StockInfoRepository extends JpaRepository<StockInfo, Integer> {

}
