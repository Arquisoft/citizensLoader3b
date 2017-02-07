package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.RList;
import es.uniovi.asw.parser.ReadList;

public class ReadExcelTest {
	
	@Test
	public void readExcelCorrect() throws Exception {
		ReadList rl = new RList();
		List<Citizen> citiziens = rl.read("src/test/resources/test.xlsx");
		
		Citizen c = citiziens.get(0);
		
		assertEquals(c.getName(), "Juan");
		assertEquals(c.getSurname(), "Torres Pardo");
		assertEquals(c.getMail(), "juan@example.com");
		assertEquals(c.getAddress(), "C/ Federico García Lorca 2");
		assertEquals(c.getNationality(), "Español");
		assertEquals(c.getDni(), "90500084Y");
		assertEquals(c.getUser(), "Juan_juan");
	}

}
