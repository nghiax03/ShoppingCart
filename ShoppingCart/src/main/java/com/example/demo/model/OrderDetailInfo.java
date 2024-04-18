package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetailInfo {
   private String id;
   private String productCode;
   private String productName;
   
   private int quantity;
   private double price;
   private double amount;
   
   //allArgsConstructor su dung choo jpa/hibernate
}
