package es.uniovi.asw.parser;

import es.uniovi.asw.dbupdate.Insert;

public class SingletonInsert {
	private static SingletonInsert instance = new SingletonInsert();
	private static Insert reporter = new InsertR();
	
	private SingletonInsert() {}
	
	public static SingletonInsert getInstance() {
		return instance;
	}
	
	public static Insert getInsert() {
		return reporter;
	}
}
