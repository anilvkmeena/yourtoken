package com.yourtoken.yourtokenadmin;

import com.yourtoken.yourtokenadmin.utility.NotificationMessage;
import com.yourtoken.yourtokenadmin.utility.PasswordGenerator;

public class Test {

	public static void main(String[] args) {
	
		PasswordGenerator passwordGenerator = new PasswordGenerator();
		System.out.println(passwordGenerator.RandomPassword());
	}

}
