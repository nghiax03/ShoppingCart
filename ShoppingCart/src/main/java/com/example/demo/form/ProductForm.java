package com.example.demo.form;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Product;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ProductForm {
	private String code;
	private String name;
	private double price;

	private boolean newProduct = true;
	private MultipartFile multipartFile;

	public ProductForm() {
		this.newProduct = true;
	}

	public ProductForm(Product product) {
		this.code = product.getCode();
		this.name = product.getName();
		this.price = product.getPrice();
	}
}
