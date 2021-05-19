package com.myanmar.phoneoperatordata.util;

import java.util.ArrayList;
import java.util.List;

public enum PhoneOperatorData {

	OOREDOO("Ooredoo", "^(09|\\+?959)("
			+ "94[0-1]\\d{6}|"
			+ "9[5-8]\\d{7})$"), 
	TELENOR("Telenor", "^(09|\\+?959)("
			+ "740\\d{6}|"
			+ "75[0-9]\\d{6}|"
			+ "7[6-9]\\d{7})$"),
	MEC("MEC", "^(09|\\+?959)("
			+ "3[0-3]\\d{6}|"
			+ "34(0|6|9)\\d{6}|"
			+ "36\\d{6})$"),
	MPT("MPT", "^(09|\\+?959)("
			+ "2[0-4]\\d{5}|"
			+ "25\\d{7}|"
			+ "26[0-9]\\d{6}|"
			+ "40[0-9]\\d{6}|"
			+ "41\\d{6}|"
			+ "42\\d{7}|"
			+ "43\\d{6}|"
			+ "44[0-9]\\d{6}|"
			+ "45\\d{7}|"
			+ "47\\d{6}|"
			+ "49\\d{6}|"
			+ "5[0-6]\\d{5}|"
			+ "73\\d{6}|"
			+ "878\\d{6}|"
			+ "8[3-7]\\d{5}|"
			+ "88[0-9]\\d{5}|"
			+ "89[0-9]\\d{6}|"
			+ "91\\d{6})$"),
	MYTEL("Mytel", "^(09|\\+?959)("
			+ "6(7|8|9)\\d{7}|"
			+ "650\\d{6}|"
			+ "66[0-9]\\d{6})$");
	
	private String operatorName;
	private String regEx;

	PhoneOperatorData(String operatorName, String regEx) {
		this.operatorName = operatorName;
		this.regEx = regEx;
	}

	public String getOperatorName() {
		return operatorName;
	}
	
	public String getRegEx() {
		return regEx;
	}

	public static PhoneOperatorData getOperatorByPhoneNumber(String phoneNumber) {
		PhoneOperatorData operator = null;
		for (PhoneOperatorData data : PhoneOperatorData.values()) {
			if (phoneNumber.matches(data.regEx)) {
				operator = data;
				break;
			}
		}
		return operator;
	}
	
	public static List<String> getAllOperator() {
		List<String> operatorNameList = new ArrayList<String>();
		for (PhoneOperatorData data : PhoneOperatorData.values()) {
			operatorNameList.add(data.getOperatorName());
		}
		return operatorNameList;
	}
}
