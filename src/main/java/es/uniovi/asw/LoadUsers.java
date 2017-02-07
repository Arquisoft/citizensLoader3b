package es.uniovi.asw;

import java.util.List;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.RList;
import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.prueba.AddCitizen;
import es.uniovi.asw.prueba.CommandExecutor;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);
	}

	// TODO
	void run(String... args) {
		System.out.println("TODO");
		CommandExecutor executor = new CommandExecutor();
		ReadList r = new RList();
		try {
			List<Citizen> ciudadanos = r.read("src/test/resources/test.xlsx");
			
			for (Citizen c: ciudadanos)
				executor.execute(new AddCitizen(c));
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
