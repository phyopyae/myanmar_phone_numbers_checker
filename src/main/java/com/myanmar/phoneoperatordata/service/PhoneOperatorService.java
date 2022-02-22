package com.myanmar.phoneoperatordata.service;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myanmar.phoneoperatordata.util.MyanmarToEnglishNumberData;
import com.myanmar.phoneoperatordata.util.PhoneOperatorData;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.myanmar.phoneoperatordata.constant.PhoneOperatorConstant;

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

	private ResponseEntity<?> getOperatorNamebyPhoneNumber(String phoneNumber, String language) {
		ResponseEntity<?> response = null;
		try {
			if (PhoneOperatorConstant.LANGUAGE_MM.equalsIgnoreCase(language)) {
				phoneNumber = MyanmarToEnglishNumberData.getEnglishNumber(phoneNumber);
			}
			
			PhoneOperatorData operator = PhoneOperatorData.getOperatorByPhoneNumber(phoneNumber);
			if (operator != null) {
				response = new ResponseEntity<>(operator.getOperatorName(), HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(PhoneOperatorConstant.PHONE_NUMBER_NOTFOUND, HttpStatus.OK);
			}
		} catch (Exception ex) {
			response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	public ResponseEntity<?> getOperatorNamebyPhoneNumberEN(String phoneNumber) {
		return getOperatorNamebyPhoneNumber(phoneNumber, PhoneOperatorConstant.LANGUAGE_EN);
	}
	
	public ResponseEntity<?> getOperatorNamebyPhoneNumberMM(String phoneNumber) {
		return getOperatorNamebyPhoneNumber(phoneNumber, PhoneOperatorConstant.LANGUAGE_MM);
	}

	public ResponseEntity<?> isPhoneNumberValid(String inputPhoneNumber) {
		ResponseEntity<?> response = null;
		PhoneNumberUtil numberUtil = PhoneNumberUtil.getInstance();
		PhoneNumber phoneNumber;
		try {
			phoneNumber = numberUtil.parse(inputPhoneNumber, "MM");
			boolean isValid = numberUtil.isValidNumber(phoneNumber);
			if (isValid) {
				response = new ResponseEntity<>(PhoneOperatorConstant.PHONE_NUMBER_VALID, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(PhoneOperatorConstant.PHONE_NUMBER_INVALID, HttpStatus.OK);
			}
		} catch (Exception ex) {
			response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
