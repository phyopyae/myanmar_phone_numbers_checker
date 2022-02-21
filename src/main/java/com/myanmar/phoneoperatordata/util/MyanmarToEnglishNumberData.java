package com.myanmar.phoneoperatordata.util;

public enum MyanmarToEnglishNumberData {

	ZERO('၀', '0'), 
	ONE('၁', '1'), 
	TWO('၂', '2'), 
	THREE('၃', '3'), 
	FOUR('၄', '4'), 
	FIVE('၅', '5'), 
	SIX('၆', '6'),
	SEVEN('၇', '7'), 
	EIGHT('၈', '8'), 
	NINE('၉', '9');

	private char myanmarNumber;
	private char englishNumber;

	public char getMyanmarNumber() {
		return myanmarNumber;
	}

	public char getEnglishNumber() {
		return englishNumber;
	}

	MyanmarToEnglishNumberData(char myanmarNumber, char englishNumber) {
		this.myanmarNumber = myanmarNumber;
		this.englishNumber = englishNumber;
	}

	public static String getEnglishNumber(String myanmarNumber) {
		String englishNumber = null;
		char [] englishNumberArray = new char[myanmarNumber.length()];
		for (int index = 0; index < myanmarNumber.length(); index++) {
			char number = myanmarNumber.charAt(index);
			for (MyanmarToEnglishNumberData data : MyanmarToEnglishNumberData.values()) {
				if (number == data.getMyanmarNumber()) {
					englishNumberArray[index] = data.getEnglishNumber();
				}
			}
		}
		englishNumber = String.valueOf(englishNumberArray);
		return englishNumber;
	}
}
