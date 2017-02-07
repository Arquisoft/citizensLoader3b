package es.uniovi.asw;

import java.util.logging.Logger;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.prueba.AddCitizen;
import es.uniovi.asw.prueba.CommandExecutor;
import es.uniovi.asw.util.DateUtil;

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
		Citizen seila = new Citizen("Seila", "Khayat Prada", "uo245392@uniovi.es", DateUtil.fromString("15/01/1996"), "c/Puerto Pontón",
				"española","Seila_uo245392","71735747", "nopass");
		try {
			executor.execute(new AddCitizen(seila));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
