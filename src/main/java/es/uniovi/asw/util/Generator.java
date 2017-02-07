package es.uniovi.asw.util;

import java.util.Random;

public class Generator {
	
	public static String password(int length) {
		String pass = "";
		long tmp = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(tmp);
		
		for (int i = 0; i < length; i++) {
			char c = (char) r.nextInt(255);
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
				pass += c;
				i++;
			}
		}
		
		return pass;
	}
	
	public static String username(String name, String mail) {
		return name+"_"+mail.split("@")[0];
	}

}
