package com.yourtoken.notificationmanager.Utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat {
	
	
	public String currentDateTime()
	{
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = now.format(formatter);
		return formatDateTime;
	}
}
