package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.OrderDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.form.CustomerForm;
import com.example.demo.model.CartInfo;
import com.example.demo.validator.CustomerFormValidator;

@Controller
@Transactional
public class MainController {
	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CustomerFormValidator customerFormValidator;
	
	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object targer = dataBinder.getTarget();
		if(targer == null) {
			return;
		}
		System.out.println("Target= " + targer);
		
		// Trường hợp update SL trên giỏ hàng.
				// (@ModelAttribute("cartForm") @Validated CartInfo cartForm)
		if(targer.getClass() == CartInfo.class) {
			
		}
		
		// Trường hợp save thông tin khách hàng.
				// (@ModelAttribute @Validated CustomerInfo customerForm)
		else if(targer.getClass() == CustomerForm.class) {
			dataBinder.setValidator(customerFormValidator);
		}
	}
	
	@RequestMapping("/403")
	public String accessDenied() {
		return "/403";
	}
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
}
