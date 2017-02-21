package es.uniovi.asw.dbupdate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.reportwriter.WriteReport;
import es.uniovi.asw.util.CitizenFinder;
import es.uniovi.asw.util.Console;
import es.uniovi.asw.util.Jpa;

public class InsertP implements Insert{
	
	private static final WriteReport reporter = new WreportR();

	@Override
	public List<Citizen> insert(List<Citizen> citizens) {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		
		List<Citizen> ciud = new ArrayList<Citizen>();
		for(Citizen c:citizens){
			if(CitizenFinder.findByDNI(c.getDNI())==null){
				Jpa.getManager().persist(c);
				ciud.add(c);
				Console.println("Se ha añadido a la base de datos a "+c.toString());
			}else{
				reporter.report("El usuario con DNI "+c.getDNI()+" ya se encontraba en la base de datos.");
			}
		}
		
		trx.commit();
		return ciud;
	}

}
