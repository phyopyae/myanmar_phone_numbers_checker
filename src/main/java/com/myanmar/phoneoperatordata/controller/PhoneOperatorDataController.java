package com.myanmar.phoneoperatordata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value="/checkValid")
	public ResponseEntity<?> checkPhoneNumberValid(@RequestParam String phoneNumber) {
		return operatorService.isPhoneNumberValid(phoneNumber);
	}
	
	@GetMapping(value="/test")
	public ResponseEntity<?> testing() {
		return new ResponseEntity<>("Test Success", HttpStatus.OK);
	}
	
}
