package com.apoorva.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.apoorva.demo.domain.Category;
import com.apoorva.demo.domain.Product;
import com.apoorva.demo.repository.CategoryRepository;
import com.apoorva.demo.repository.ProductRepository;

@Service
public class CSVService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	
	public static String MIMETYPE = "text/csv";
	static String[] HEADERS = { "date_of_expiry", "description", "discount", "name", 
			 "price", "quantity", "vendor", "category_id", "inventory_id"};
	
	
	
	//check for file type
	public boolean iscorrectFormat(MultipartFile file) {
		if(MIMETYPE.equals(file.getContentType())) {
			return true;
		}
		return false;
	}
	
	
	//convert CSV to product list
	public List<Product> csvToProductList(InputStream inputStream) throws IOException{
		
		BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		
		CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
		List<Product> productList = new ArrayList<>();
		
		Iterable<CSVRecord> csvRecords = csvParser.getRecords();
		List<Category> categories = categoryRepository.findAll();
		 
		Map<Integer, Category> categoryIdMap = new HashMap<>();
		for(Category c: categories) {
			categoryIdMap.put(c.getId(),c);
		 }
		for (CSVRecord csvRecord : csvRecords) {
			  Product product = new Product();
			  product.setName(csvRecord.get("name"));
			  product.setDescription(csvRecord.get("description"));
			  product.setPrice(Integer.parseInt(csvRecord.get("price")));
			  product.setDiscount(Integer.parseInt(csvRecord.get("discount")));
			  product.setQuantity(Integer.parseInt(csvRecord.get("quantity")));
			  product.setDateOfExpiry(LocalDate.parse(csvRecord.get("date_of_expiry"), formatter));
			  product.setVendor(csvRecord.get("vendor"));
			  product.setCategory(categoryIdMap.get(Integer.parseInt(csvRecord.get("category_id"))));
			  productList.add(product);
		  }
		return productList;
	}
	
	public void save(MultipartFile file) throws IOException {
		List<Product> productList = csvToProductList(file.getInputStream());
		productRepository.saveAll(productList);
	}
		
	public List<Product> getAllProducts() {
	    return productRepository.findAll();
	}
}
