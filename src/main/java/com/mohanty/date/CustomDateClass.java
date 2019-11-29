package com.mohanty.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateClass {
	
	public CustomDateClass() {}

	public String getCurrentDate() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-YYYY HH:mm:ss");
		String pattern = sdf.format(new Date());
		return pattern;

	}

}