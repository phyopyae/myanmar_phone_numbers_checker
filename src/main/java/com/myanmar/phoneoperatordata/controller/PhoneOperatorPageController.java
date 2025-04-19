package com.myanmar.phoneoperatordata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myanmar.phoneoperatordata.service.PhoneOperatorService;

@Controller
public class PhoneOperatorPageController {

	@Autowired
	PhoneOperatorService operatorService;
	
	@GetMapping("/")
	public String loginPage() {
		return "home_page";
	}
	
	@PostMapping("/check")
	private String getTestPage(Model model, @RequestParam String phonenumber) {
		String operatorName = operatorService.getOperatorNamebyPhoneNumber(phonenumber);
		model.addAttribute("message", operatorName);
		return "home_page";
	}
}
