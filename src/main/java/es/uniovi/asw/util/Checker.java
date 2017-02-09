package es.uniovi.asw.util;

import java.util.Date;

public class Checker {
	
	public static String name(String name) throws Exception {
		if (isNull(name))
			throw new Exception("El nombre no puede ser un dato nulo");
		
		return name;
	}
	
	public static String surname(String surname) throws Exception {
		if (isNull(surname) || surname == "")
			throw new Exception("El apellido no puede ser un dato nulo");
		
		return surname;
	}
	
	public static String mail(String mail) throws Exception {
		if (isNull(mail))
			throw new Exception("El mail no puede ser un dato nulo");
		
		return mail;
	}
	
	public static Date date(Date date) throws Exception {
		if (isNull(date))
			throw new Exception("La fecha no puede ser un dato nulo");
		
		return date;
	}
	
	public static String address(String address) throws Exception {
		if (isNull(address))
			throw new Exception("La direccion no puede ser un dato nulo");
		
		return address;
	}
	
	public static String nationality(String nationality) throws Exception {
		if (isNull(nationality))
			throw new Exception("La nacionalidad no puede ser un dato nulo");
		
		return nationality;
	}
	
	public static String dni(String dni) throws Exception {
		if (isNull(dni)) 
			throw new Exception("El dni no puede ser un dato nulo");
		
		return dni;
	}
	
	private static boolean isNull(Object obj) {
		if (obj == null)
			return true;
		return false;
	}
}
