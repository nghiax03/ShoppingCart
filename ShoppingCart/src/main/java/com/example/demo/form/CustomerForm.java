package com.example.demo.form;

import com.example.demo.model.CustomerInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CustomerForm {
	private String name;
	private String address;
	private String email;
	private String phone;

	private boolean valid;

	public CustomerForm(CustomerInfo customerInfo) {
		if (customerInfo != null) {
			this.name = customerInfo.getName();
			this.address = customerInfo.getAddress();
			this.email = customerInfo.getEmail();
			this.phone = customerInfo.getPhone();
		}
	}
}
