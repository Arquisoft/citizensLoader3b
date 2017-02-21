package es.uniovi.asw.parser;


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
