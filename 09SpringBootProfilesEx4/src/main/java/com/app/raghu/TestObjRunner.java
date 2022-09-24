package com.app.raghu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.raghu.service.ExportExcelService;
import com.app.raghu.service.PdfExportService;

@Component
public class TestObjRunner implements CommandLineRunner {
	
	@Autowired
	private ExportExcelService es;
	
	@Autowired
	private PdfExportService pdfs;
	
	public void run(String... args) throws Exception {
		System.out.println(es);
		System.out.println(pdfs);
	}

}
