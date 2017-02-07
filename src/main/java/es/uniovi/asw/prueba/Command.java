package es.uniovi.asw.prueba;

import es.uniovi.asw.model.exception.BusinessException;

public interface Command {

	Object execute() throws BusinessException;
}
