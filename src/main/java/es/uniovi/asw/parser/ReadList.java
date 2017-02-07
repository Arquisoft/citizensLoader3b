package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.model.Citizen;

public interface ReadList {
	public List<Citizen> read(String path);
}
