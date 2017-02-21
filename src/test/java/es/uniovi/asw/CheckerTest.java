package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import org.junit.Test;

import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.util.Checker;


public class CheckerTest {

	

	
	@Test
	public void CheckearTodoCorrecto() throws Exception {
		assertEquals(Checker.name("Pepe", 1, 1, "1"),"Pepe");
		Date d=new Date();
		assertEquals(Checker.date(d, 1, 1,"1"),d);
		assertEquals(Checker.address("C/ Prueba", 1, 1,"1"),"C/ Prueba");
		assertEquals(Checker.dni("48631254", 1, 1, "1"),"48631254");
		assertEquals(Checker.mail("asdas@asd.es", 1, 1, "1"),"asdas@asd.es");
		assertEquals(Checker.nationality("pruebaland", 1, 1, "1"),"pruebaland");
		assertEquals(Checker.surname("Pipo", 1, 1, "1"),"Pipo");
	}
	
	@Test(expected = BusinessException.class) 
	public void NameNull() throws BusinessException{
		Checker.name(null, 1, 1, "1");
	}
	@Test(expected = BusinessException.class) 
	public void DateNull() throws Exception{
		Checker.date(null, 1, 1,"1");
	}
	@Test(expected = BusinessException.class) 
	public void AddressNull() throws Exception{
		Checker.address(null, 1, 1,"1");
	}
	@Test(expected = BusinessException.class) 
	public void DniNull() throws Exception{
		Checker.dni(null, 1, 1,"1");
	}
	@Test(expected = BusinessException.class) 
	public void MailNull() throws Exception{
		Checker.mail(null, 1, 1,"1");
	}
	@Test(expected = BusinessException.class) 
	public void MailFaltaA() throws Exception{
		Checker.mail("asda.es", 1, 1,"1");
	}
	@Test(expected = BusinessException.class) 
	public void MailFaltaP() throws Exception{
		Checker.mail("as@das", 1, 1,"1");
	}
	@Test(expected = BusinessException.class) 
	public void MailFaltaT() throws Exception{
		Checker.mail("asdas", 1, 1,"1");
	}
	@Test(expected = BusinessException.class) 
	public void NationalityNull() throws Exception{
		Checker.nationality(null, 1, 1,"1");
	}
	@Test(expected = BusinessException.class) 
	public void SurnameNull() throws Exception{
		Checker.surname(null, 1, 1,"1");
	}
}
