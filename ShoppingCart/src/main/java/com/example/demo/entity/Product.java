package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Products")
@NoArgsConstructor
@Getter
@Setter
public class Product implements Serializable{
	 private static final long serialVersionUID = -1000119078147252957L;

	@Id
	@Column(name = "Code", length = 20, nullable = false)
	private String code;
	
	@Column(name = "Name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "Price", nullable = false)
	private double price;
	
	//larget object: kieu du lieu lon
	@Lob
	@Column(name = "Image", length = Integer.MAX_VALUE)
	private byte[] image;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Create_Date", nullable = false)
	private Date createDate;
	
	
	
}
