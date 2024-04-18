package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Order_Details")
@Getter
@Setter
public class OrderDetails implements Serializable {
	private static final long serialVersionUID = 7550745928843183535L;

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID", nullable = false, //
			foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false, //
			foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD_FK"))
	private Product product;

	@Column(name = "Quantity", nullable = false)
	private int quantity;

	@Column(name = "Price", nullable = false)
	private double price;

	@Column(name = "Amount", nullable = false)
	private double amount;

}
