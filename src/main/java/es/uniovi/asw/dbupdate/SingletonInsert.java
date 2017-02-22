package es.uniovi.asw.dbupdate;

public class SingletonInsert {
	private static SingletonInsert instance = new SingletonInsert();
	private static Insert insert = new InsertP();
	
	private SingletonInsert() {}
	
	public static SingletonInsert getInstance() {
		return instance;
	}
	
	public static Insert getInsert() {
		return insert;
	}
}
