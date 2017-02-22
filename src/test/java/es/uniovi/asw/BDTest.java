package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.dbupdate.InsertP;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.util.CitizenFinder;
import es.uniovi.asw.util.Generator;
import es.uniovi.asw.util.Jpa;

public class BDTest {

	@Before
	public void setUp() {
		try{
			EntityManager mapper = Jpa.createEntityManager();
			EntityTransaction trx = mapper.getTransaction();
			List<Citizen> lista = CitizenFinder.findAll();
			for(Citizen c:lista){
				trx.begin();
				Jpa.getManager().remove(c);
				trx.commit();
			}
		}catch(Exception e){
			
		}
		
		
	}

	@Test
	public void test() {
		Citizen seila = new Citizen("Seila", "Prada", "seila@hotm.com", new Date(), "direccion", "espa", "71735747N",
				Generator.username("Seila", "seila@hotm.com"), Generator.password(10, 43));
		Citizen seila2 = new Citizen("Seila2", "Prada", "seila@hotm.com", new Date(), "direccion", "espa", "71735547N",
				Generator.username("Seila2", "seila@hotm.com"), Generator.password(10, 54));
		Citizen seila3 = new Citizen("Seila3", "Prada", "seila@hotm.com", new Date(), "direccion", "espa", "71733247N",
				Generator.username("Seila3", "seila@hotm.com"), Generator.password(10, 34));

		
		List<Citizen> lista = new ArrayList<Citizen>();
		lista.add(seila);
		lista.add(seila2);
		lista.add(seila3);
		
		Insert ins = new InsertP();
		ins.insert(lista);
		
		assertEquals(3, CitizenFinder.findAll().size());
		assertNotNull(CitizenFinder.findByDNI(seila.getDNI()));
		assertNotNull(CitizenFinder.findByDNI(seila2.getDNI()));
		assertNotNull(CitizenFinder.findByDNI(seila3.getDNI()));

		
		ins.insert(lista);
		assertEquals(3, CitizenFinder.findAll().size());
		
		Citizen dnirepetido = new Citizen("SDASA", "SAASD", "WQEQE@hotm.com", new Date(), "direccion", "espa", "71735747N",
				Generator.username("SDASA", "WQEQE@hotm.com"), Generator.password(10, 45354));
		
		lista.add(dnirepetido);
		ins.insert(lista);
		assertEquals(3, CitizenFinder.findAll().size());
		assertTrue("Seila".equalsIgnoreCase(CitizenFinder.findByDNI("71735747N").getNombre()));
		
		
	}

}
