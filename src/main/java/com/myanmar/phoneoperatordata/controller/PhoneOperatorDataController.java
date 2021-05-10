package com.myanmar.phoneoperatordata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myanmar.phoneoperatordata.service.PhoneOperatorService;

@RestController
@RequestMapping("/operator")
public class PhoneOperatorDataController {

	@Autowired
	PhoneOperatorService operatorService;
	
	@GetMapping(value="/list")
	public ResponseEntity<?> getAllOperator() {
		return operatorService.getAllOperatorNameList();
	}
	
	@GetMapping(value="/find")
	public ResponseEntity<?> getOperatorByPhoneNumber(@RequestParam String phoneNumber) {
		return operatorService.getOperatorNamebyPhoneNumber(phoneNumber);
	}
}
