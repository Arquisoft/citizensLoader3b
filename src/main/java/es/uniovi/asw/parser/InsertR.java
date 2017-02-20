package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.dbupdate.AddCitizen;
import es.uniovi.asw.dbupdate.CommandExecutor;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;

public class InsertR {
	
	public void insert(List<Citizen> citizens) {
		CommandExecutor cmd = new CommandExecutor();
		
		for (Citizen c: citizens)
			try {
				cmd.execute(new AddCitizen(c));
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
