package com.fluig.challenge.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Util {
	
	public static Double format3CasasDecimais(Double value) {
		DecimalFormat df = new DecimalFormat("#,###.000");
		return Double.valueOf(df.format(value).replace(",", "."));
	}
	
	public static Integer formatDataAno(Instant value) {
		Date myDate = Date.from(value);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String formattedDate = sdf.format(myDate);
		return  Integer.valueOf(formattedDate);
	}

}
