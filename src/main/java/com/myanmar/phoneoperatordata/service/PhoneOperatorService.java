package com.myanmar.phoneoperatordata.service;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myanmar.phoneoperatordata.util.PhoneOperatorData;

@Service
public class PhoneOperatorService {

	public ResponseEntity<?> getAllOperatorNameList() {
		ResponseEntity<?> response = null;
		try {
			List<String> operatorNameList = PhoneOperatorData.getAllOperator();
			Collections.sort(operatorNameList);
			response = new ResponseEntity<>(operatorNameList.toString(), HttpStatus.OK);
		} catch (Exception ex) {
			response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	public ResponseEntity<?> getOperatorNamebyPhoneNumber(String phoneNumber) {
		ResponseEntity<?> response = null;
		try {
			PhoneOperatorData operator = PhoneOperatorData.getOperatorByPhoneNumber(phoneNumber);
			if (operator != null) {
				response = new ResponseEntity<>(operator.getOperatorName(), HttpStatus.OK);
			} else {
				response = new ResponseEntity<>("Operator Not Found!", HttpStatus.OK);
			}
		} catch (Exception ex) {
			response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
