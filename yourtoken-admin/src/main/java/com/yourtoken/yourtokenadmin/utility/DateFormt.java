package com.yourtoken.yourtokenadmin.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormt {
	
	
	public String currentDateTime()
	{
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = now.format(formatter);
		return formatDateTime;
	}
}
