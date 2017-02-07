package es.uniovi.asw.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uniovi.asw.model.Citizen;

public abstract class Reader {
	
	protected String path;
	
	protected String name;
	protected String surname;
	protected String mail;
	protected Date date;
	protected String address;
	protected String nationality;
	protected String dni;
	
	protected String username;
	protected String password;
	
	protected List<Citizen> citiziens = new ArrayList<Citizen>();
	
	public List<Citizen> readFile(String path) {
		this.path = path;
		execute();
		return citiziens;
	}
	
	public abstract void execute();

}
