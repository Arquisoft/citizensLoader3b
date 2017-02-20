package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.RList;
import es.uniovi.asw.parser.ReadList;

public class ReadTest {
	
	@Test
	public void readExcelCorrect() throws Exception {
		ReadList rl = new RList();
		List<Citizen> citiziens = rl.read("src/test/resources/test.xlsx");
		
		Citizen c = citiziens.get(0);
		
		assertEquals(c.getNombre(), "Juan");
		assertEquals(c.getApellidos(), "Torres Pardo");
		assertEquals(c.getEmail(), "juan@example.com");
		assertEquals(c.getDireccion(), "C/ Federico García Lorca 2");
		assertEquals(c.getNacionalidad(), "Español");
		assertEquals(c.getDNI(), "90500084Y");
		assertEquals(c.getUsuario(), "Juan_juan");
	}
	
	@Test
	public void readTextPlainCorrect() throws Exception {
		ReadList rl = new RList();
		List<Citizen> citiziens = rl.read("src/test/resources/test.txt");
		
		Citizen c = citiziens.get(0);
		
		assertEquals(c.getNombre(), "Eduardo");
		assertEquals(c.getApellidos(), "Martinez Chillon");
		assertEquals(c.getEmail(), "ele_du@hotmail.es");
		assertEquals(c.getNacionalidad(), "Español");
		assertEquals(c.getDNI(), "71751099T");
		assertEquals(c.getUsuario(), "Eduardo_ele_du");
	}
	
	@Test
	public void readEmailInCorrect() throws Exception {
		ReadList rl = new RList();
		List<Citizen> citiziens = rl.read("src/test/resources/testEmailIncorrect.txt");
		
		assertEquals(2, citiziens.size()+1);
		
		citiziens = rl.read("src/test/resources/testEmailIncorrect.xlsx");
		
		assertEquals(2, citiziens.size()+1);
	}

}
