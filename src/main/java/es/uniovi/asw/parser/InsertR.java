package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.dbupdate.InsertP;
import es.uniovi.asw.model.Citizen;

public class InsertR implements Insert{

	@Override
	public List<Citizen> insert(List<Citizen> citizens) {
		
		return new InsertP().insert(citizens);
	}
	

}

