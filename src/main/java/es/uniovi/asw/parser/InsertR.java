package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.dbupdate.InsertP;
import es.uniovi.asw.model.Citizen;

public class InsertR {
	
	public void insert(List<Citizen> citizens) {
		new InsertP().insert(citizens);
	}

}

