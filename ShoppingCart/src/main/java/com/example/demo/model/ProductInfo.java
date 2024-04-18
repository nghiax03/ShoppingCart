package com.example.demo.model;

import java.util.Date;

import com.example.demo.entity.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductInfo {
	private String code;
    private String name;
    private double price;
    
    public ProductInfo(Product product) {
    	this.code = product.getCode();
    	this.name = product.getName();
    	this.price = product.getPrice();
    }
    
    // Sử dụng trong JPA/Hibernate query
    public ProductInfo(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

}
