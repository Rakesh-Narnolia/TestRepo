package com.rk.test.gitdemo.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
	static Logger logger = Logger.getLogger(ValidatorUtil.class.getName());

	/**
	 * This method is common and used 1. to Compare two dates
	 * 
	 * @author Rakesh Narnolia
	 * @param dateToCompared
	 *            - Date to Compare
	 * @param dateToBeComparedWith
	 *            - Date to Compare With.
	 * @return result - if any of the Items are null or blank, return -999 else
	 *         return 0 if the dates are equal, -1 if the date is before, 1 if
	 *         the date is after
	 */
	public static int compareTwoDates(String dateToCompared, String dateToBeComparedWith) {
		int result = -999;
		Date dateToCompare = null;
		Date dateToBeCompared = null;
		if ((dateToCompared != null && !(dateToCompared.equalsIgnoreCase(""))) && (dateToBeComparedWith != null && !(dateToBeComparedWith.equalsIgnoreCase("")))) {
			dateToCompare = returnFormattedDate(dateToCompared);
			dateToBeCompared = returnFormattedDate(dateToBeComparedWith);
			if (dateToCompare.equals(dateToBeCompared)) {
				result = 0;
			} else if (dateToCompare.after(dateToBeCompared)) {
				result = 1;
			} else if (dateToCompare.before(dateToBeCompared)) {
				result = -1;
			}
		}
		return result;
	}

	/**
	 * This method is common and used 1. to return Date variable of the Format
	 * "dd/MM/yyyy"
	 * 
	 * @author Rakesh Narnolia
	 * @param strDate
	 *            - String ,which need to be changed to Date variable
	 * @return retDate - Returned Date variable
	 */
	public static Date returnFormattedDate(String strDate) {
		Date retDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			retDate = sdf.parse(strDate);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error in Parsing Date" + e.getLocalizedMessage());
		}
		return retDate;
	}

	/**
	 * @param args
	 */
	public static boolean isNumeric(String input) {
		try {
			if (input != null) {
				String pattern = ValidationConstant.numberpattern;
				if (input.matches(pattern)) {
					return true;
				}
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean dateCompareFromDate(String dt1, String dt2) {
		int i = compareTwoDates(dt1, dt2);
		boolean flag=false;
		if (i != -999) {
			if (i == -1) {
				flag= true;
			} else
				flag= false;
		}
		return flag;
	}

	public  static  boolean dateCompareEndDate(String dt1, String dt2) {
		int i =  compareTwoDates(dt1, dt2);
		boolean flag=false;
		if (i != -999) {
			if (i == 1) {
				flag= true;
			} else
				flag= false;
		}
		return flag;
	}

	public   static  boolean isAlphaNumeric(String input) {
		try {
			if (input != null) {
				String pattern = ValidationConstant.isAlphaNumeric_pattern;
				if (input.matches(pattern)) {
					return true;
				}
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}


	public   static  boolean isEmpty(String input) {
		try {
			if (input == null || input.trim().equals("")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return true;
		}
	}

	public   static  boolean isNull(String input) {
		try {
			if (input == null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return true;
		}
	}

	public  static  boolean lengthCheck(String input, int length) {
		try {
			if (input != null) {
				if (input.length() == length) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public   static int strLength(String input) {
		int len = 0;
		try {
			if (!isEmpty(input)) {
				len = input.length();
			}
		} catch (Exception e) {
			return 0;
		}
		return len;
	}

	public  static  boolean minmaxLength(String input, int minLength, int maxLength) {
		try {
			int strlen = 0;
			if (input != null) {
				strlen = input.length();
			}
			if (minLength != 0 && strlen < minLength) {
				return false;
			}
			if (maxLength != 0 && strlen > maxLength) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public   static boolean isEmail(String input) {
		String EMAIL_PATTERN = ValidationConstant.email_pattern;
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public  static  boolean isPan(String str) {
		String regex = ValidationConstant.pan_pattern;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
	public  static  boolean isValidCompleteFaxNo(String str){
		boolean valid = true;
		if(str!=null){
			if(str.startsWith("+91") && str.length()>3 &&  str.length()!=13){
				valid = false;
			}
		}
		return valid;
	}

	public  static  boolean isValidCompleteTelephoneNo(String str){
		boolean valid = true;
		if(str!=null){
			if(str.startsWith("+91") && str.length()>3 &&  str.length()!=13){
				valid = false;
			}
		}
		return valid;
	}
	public boolean isPinCode(String str) {
		String regex = ValidationConstant.pincode_pattern;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValidPin4Haryana(String pin, String state) {
		if (state == null || state.trim().equals("") || !state.trim().equalsIgnoreCase("haryana")) {
			return true;
		} else {
			if (pin == null || pin.trim().equals("")) {
				return true;
			} else {
				if (pin.startsWith("1")) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

	public  static  boolean isLandLine(String value) {
		String regex = ValidationConstant.islandline_pattern;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public  static  boolean isMobileNumber(String input) {
		String regex = ValidationConstant.isMobile_pattern;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			if (input.startsWith("0")) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	public   static boolean isdate(String date) {
		Date inputDate = null;
		String refreshDate;
		String regex = ValidationConstant.isDate_pattern;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		try {
			if (matcher.matches()) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				inputDate = sdf.parse(date);
				refreshDate = sdf.format(inputDate);
				if (refreshDate != null && refreshDate.equals(date)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public  static  boolean isFutureDate(String date) {
		Date inputDate = null;
		Date todayDate = null;
		boolean result = false;
		try {
			if (isdate(date)) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String current1 = sdf.format(new Date());
				inputDate = sdf.parse(date);
				todayDate = sdf.parse(current1);
				if (inputDate != null && todayDate != null) {
					if (todayDate.compareTo(inputDate) < 0) {
						result = true;
					} else {
						result = false;
					}
				} else {
					result = false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public  static  boolean isPastDated(String date) {
		Date inputDate = null;
		Date todayDate = null;
		boolean result = false;
		try {
			if (isdate(date)) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String current1 = sdf.format(new Date());
				inputDate = sdf.parse(date);
				todayDate = sdf.parse(current1);
				if (inputDate != null && todayDate != null) {
					if (todayDate.compareTo(inputDate) > 0) {
						result = true;
					} else {
						result = false;
					}
				} else {
					result = false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public   static  boolean isCurrentDate(String date) {
		Date inputDate = null;
		Date todayDate = null;
		boolean result = false;
		try {
			if (isdate(date)) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String current1 = sdf.format(new Date());
				inputDate = sdf.parse(date);
				todayDate = sdf.parse(current1);
				if (inputDate != null && todayDate != null) {
					if (todayDate.compareTo(inputDate) == 0) {
						result = true;
					} else {
						result = false;
					}
				} else {
					result = false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public  static  boolean isAllowdSpcl(String input) {
		String regexpChars = ValidationConstant.alphaSpecialChar_pattern;
		Matcher matcher;
		Pattern pattern = Pattern.compile(regexpChars);
		matcher = pattern.matcher(input);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public   static boolean isNameWithSpecialChar(String input) {
		String regexpChars = ValidationConstant.nameWithSpecial_pattern;
		Matcher matcher;
		Pattern pattern = Pattern.compile(regexpChars);
		matcher = pattern.matcher(input);
		if (matcher.matches()) {
			return false;
		} else {
			return true;
		}
	}

	public   static boolean isAlphanumeric(String input) {
		String regex = ValidationConstant.alphanumeric_pattern;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public  static  boolean minmaxlength(String input) {
		String data = input;
		if (data.length() < 50 && data.length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public  static  boolean chkAllZero(String input) {
		try {
			int tinVal = Integer.parseInt(input);
			if (tinVal == 0) {
				return false;
			} else
				return true;
		} catch (Exception e) {
			e.getMessage();
			return true;
		}
	}

	public  static  boolean isDecimal(String input, String decimalPlace) {
		String regex = ValidationConstant.decimal_pattern;
		int decPlace = 0;
		try {
			decPlace = (int) Double.parseDouble(decimalPlace);
		} catch (Exception e) {
			decPlace = 0;
		}
		if (decPlace == 0) {
			regex = regex.replace(":DECIMAL_PLACE:", "*");
		} else {
			regex = regex.replace(":DECIMAL_PLACE:", "{0," + decPlace + "}");
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
		
	}

	public   static boolean isDecimalPlaces(String input) {
		String regex = ValidationConstant.decimalPlaces_pattern;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public  static  boolean isAlphaAndSpecial(String input) {
		String regex = ValidationConstant.alphaSpecialChar_pattern;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public  static  boolean isText(String input) {
		try {
			if (input != null && !input.equals("")) {
				String pattern = ValidationConstant.text_pattern;
				if (input.matches(pattern)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}


	public  static  boolean isFaxNo(String value) {
		String regex = ValidationConstant.fax_no;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public   static boolean isMinimum(double valueAllowed, String CompareValue) {
		double actualValue = Double.parseDouble(CompareValue.replaceAll(",", ""));
		if (actualValue < valueAllowed)
			return false;
		else
			return true;
	}

	public  static  boolean isMaximum(double valueAllowed, String CompareValue) {
		double actualValue = Double.parseDouble(CompareValue.replaceAll(",", ""));
		if (actualValue > valueAllowed)
			return false;
		else
			return true;
	}

	public  static  boolean isMinimumExcludingMin(double valueAllowed, String CompareValue) {
		double actualValue = Double.parseDouble(CompareValue.replaceAll(",", ""));
		if (actualValue <= valueAllowed)
			return false;
		else
			return true;
	}

	public   static boolean isMaximumExcludingMax(double valueAllowed, String CompareValue) {
		double actualValue = Double.parseDouble(CompareValue.replaceAll(",", ""));
		// int actualValue= Integer.parseInt(CompareValue);
		if (actualValue >= valueAllowed)
			return false;
		else
			return true;
	}

	public   static boolean isSTDCode(String value) {
		String regex = ValidationConstant.STDCODE;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public  static  boolean isCountryCode(String value) {
		String regex = ValidationConstant.COUNTRYCODE;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	public   static boolean isContaingOnlyZero(String val) {
		boolean zeroFlag = true;
		val = val.trim();
		char tmpchar;
		for (int i = 0; i < val.length(); i++) {
			tmpchar = val.charAt(i);
			if (tmpchar != '0') {
				zeroFlag = false;
				break;
			}
		}
		return zeroFlag;
	}
	
		
}


