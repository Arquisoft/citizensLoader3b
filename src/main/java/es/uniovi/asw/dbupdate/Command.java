package es.uniovi.asw.dbupdate;

import es.uniovi.asw.model.exception.BusinessException;

public interface Command {

	Object execute() throws BusinessException;
}
