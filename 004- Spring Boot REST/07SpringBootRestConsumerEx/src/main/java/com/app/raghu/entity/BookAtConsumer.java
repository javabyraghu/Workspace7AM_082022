package com.app.raghu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAtConsumer {

	private Integer bid;
	private String bname;
	private String bauth;
	private Double bcost;
}
