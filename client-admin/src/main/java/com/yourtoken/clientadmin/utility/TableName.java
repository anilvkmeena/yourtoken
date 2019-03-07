package com.yourtoken.clientadmin.utility;

import java.time.LocalDate;

public class TableName {
	public static String tName()
	{
		LocalDate date = LocalDate.now();
		String	tableName = ""+date;
		return tableName;
		
	}
}
