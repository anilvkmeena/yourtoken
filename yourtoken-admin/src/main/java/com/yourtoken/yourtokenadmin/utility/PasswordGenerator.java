package com.yourtoken.yourtokenadmin.utility;

import java.util.Random;

import org.apache.commons.text.RandomStringGenerator;

public class PasswordGenerator {
	
	public String RandomPassword()
	{
		int temp;
		temp = (int) (Math.random()*10000000);
		return temp+"";
		
	}
}
