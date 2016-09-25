package br.com.cubotecnologia.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	
	private static final String DATE_PATTERN_BR = "dd/MM/yyyy HH:mm:ss";
	
	private static final String LOCALE_LANGUAGE_PATTERN_BR = "pt";
	
	private static final String LOCALE_COUNTRY_PATTERN_BR = "BR";
	
	public static Date getDateFromString (String sDateTime) throws ParseException {
		DateFormat formatter = getDateFormat();
		return formatter.parse(sDateTime);
	}
	
	public static SimpleDateFormat getDateFormat (){
		return new SimpleDateFormat(DATE_PATTERN_BR, new Locale(LOCALE_LANGUAGE_PATTERN_BR, LOCALE_COUNTRY_PATTERN_BR));
	}
}
