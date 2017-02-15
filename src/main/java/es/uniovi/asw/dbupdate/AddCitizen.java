package es.uniovi.asw.dbupdate;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.util.Jpa;

public class AddCitizen implements Command{
	
	private Citizen citizen;
	
	public AddCitizen(Citizen citizen){
		this.citizen = citizen;
	}

	@Override
	public Object execute() throws BusinessException {
		
		Jpa.getManager().persist(citizen);
		
		
		return citizen;
	}

}
