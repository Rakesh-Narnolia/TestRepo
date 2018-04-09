package com.rk.test.gitdemo.util;

public class ValidationConstant {
	public static final String isAlphaNumeric_pattern = "^[a-zA-Z0-9]*$";
    public static final String mandatoryMsg = "Please Enter";
    public static final String numericMsg =" should be numeric.";
    public static final String alphabetMsg = " should contain alphabet.";
    public static final String lengthMsg = " Exceeds max limit";
    public static final String text_pattern ="^[\\p{L} ]+$";
    public static final String alphaSpecialChar_pattern="^[A-Za-z0-9 {L} \\@\\#\\$\\%\\&\\*\\(\\)\\-\\_\\+\\]\\[\\'\\;\\:\\?\\.\\,\\/\\!]*$";         //"^[A-Za-z0-9 {L} \\-\\#\\,\\/\\^]*$";
    public static final String decimalPlaces_pattern="^\\d+(?:[.,]\\d{2})?$";
    public static final String decimal_pattern="^\\d*\\,?\\d*\\,?\\d*\\,?\\d*\\,?\\d*\\,?\\d*\\.?\\d:DECIMAL_PLACE:$";    // ^\\d*\\.?\\d{0,2}$ //^\\d*\\.?\\d*$
    public static final String alphanumeric_pattern="^[\\pN{L} \\p{L}\\pN ]+$";    //"^[a-zA-Z0-9]*$";
    public static final String nameWithSpecial_pattern="^[a-zA-Z0-9\\@\\#\\$\\%\\&\\*\\(\\)\\-\\_\\+\\]\\[\\'\\;\\:\\?\\.\\,\\!\\^]+$";
    public static final String allowdSpecial_pattern="^[a-zA-Z0-9]{1,}$";
    public static final String isDate_pattern="^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
    public static final String isMobile_pattern="^[0-9]*$";
    public static final String islandline_pattern="^[1-9]{1}[0-9]*$";   //"^[0-9]*$";// "\\+[0-9]{3}[-][0-9]{8}";
    public static final String pincode_pattern="^[1-9]{1}[0-9]*$";   //"[0-9]{6}";
    public static final String pan_pattern="[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}";
    public static final String servicetax_pattern="[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[sS]{1}[dD|tT]{1}[0-9]{3}";

    public static final String email_pattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String numberpattern="^[0-9]*$";
    public static final String vehicle_Regno="^[a-zA-Z]{1}[a-zA-Z0-9]*$";
    public static final String Perm_Regno="^[A-Z]{1}[A-Z]*\\d+[A-Z]*\\d*[A-Z]*$";
    public static final String fax_no="^[1-9]{1}[0-9]*$";   //"^[0-9]*$";
	public static final String STDCODE="^[1-9]{1}[0-9]*$";
	public static final String COUNTRYCODE="^[+]{1}[1-9]*$";     //"^([\\+]{1}[0-9]{2})$";


}
