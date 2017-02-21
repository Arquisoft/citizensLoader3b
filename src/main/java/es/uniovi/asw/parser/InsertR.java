package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.dbupdate.SingletonInsert;
import es.uniovi.asw.model.Citizen;

public class InsertR implements Insert{

	@Override
	public List<Citizen> insert(List<Citizen> citizens) {
		
		return SingletonInsert.getInsert().insert(citizens);
	}
	

}

