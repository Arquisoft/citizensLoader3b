package es.uniovi.asw.dbupdate;

import java.util.List;

import es.uniovi.asw.model.Citizen;

public interface Insert {
	/**
	 * Método que mete los ciudadanos en la base de datos
	 * @param citizens que ha leido el parser
	 * @return citizens que se han podido meter
	 */
	List<Citizen> insert(List<Citizen> citizens);
}
