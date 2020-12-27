package com.apoorva.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.apoorva.demo.service.CSVService;

@Controller
public class CsvController {
	
	
	@Autowired
	CSVService csvService;
	
	@PostMapping("/bulkproductuploadcsv")
	public String bulkProductUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		if (csvService.iscorrectFormat(file)) {
			csvService.save(file);
		}
		return "redirect:customerviewproducts/";
	}
}
