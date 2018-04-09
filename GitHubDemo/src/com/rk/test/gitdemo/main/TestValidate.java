package com.rk.test.gitdemo.main;

import static com.rk.test.gitdemo.util.ValidatorUtil.isEmail;

import java.util.logging.Logger;
public class TestValidate {
	static Logger logger = Logger.getLogger(TestValidate.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String email="abc@gmail.com";
		logger.info("Valid Email >>>"+ isEmail(email));
		
		String invEmail="abcgmail.com";
		logger.info("Valid Email >>>"+ isEmail(invEmail));
		
	}

}
