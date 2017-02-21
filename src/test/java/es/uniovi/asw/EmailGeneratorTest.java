package es.uniovi.asw;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import es.uniovi.asw.email.EmailGenerator;
import es.uniovi.asw.model.Citizen;


public class EmailGeneratorTest {
	Citizen c;
	
	@Before
	public void inizializar(){
		c=new Citizen("Juan",  "Torres Pardo", "juan@example.com", new Date(),"C/ Lo que sea",
				"Rumania", "90500084Y","adada", "12345");
	}
	
	@Test
	public void crearPDF() throws Exception {
		File archivo=EmailGenerator.generate("pdf", c);	
		assertTrue(archivo.getAbsolutePath().endsWith(".pdf"));
		assertTrue(archivo.getAbsolutePath().contains("90500084Y"));
	}
	
	@Test
	public void crearWord() throws Exception {
		File archivo=EmailGenerator.generate("word", c);	
		assertTrue(archivo.getAbsolutePath().endsWith(".docx"));
		assertTrue(archivo.getAbsolutePath().contains("90500084Y"));
	}
	

}
