package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartLineInfo {
	private ProductInfo productInfo;
	private int quantity;
	public CartLineInfo() {
		// TODO Auto-generated constructor stub
		this.quantity = 0;
	}
	
	public double getAmount() {
		return this.productInfo.getPrice() * this.quantity;
	}
}
