package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.dbupdate.SingletonInsert;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.reader.ParserExcel;
import es.uniovi.asw.parser.reader.ParserTextPlain;
import es.uniovi.asw.util.Console;

public class RList implements ReadList {
	
	private Parser reader;
	
	@Override
	public List<Citizen> read(String path) {
		String extension = path.split("\\.")[1];
		List<Citizen> citizens;
		
		if (extension.equals("xlsx"))
			reader = new ParserExcel();
		else if (extension.equals("txt"))
			reader = new ParserTextPlain();
		else
			Console.print("El fichero no tiene un formato correcto");
		
		citizens = reader.readFile(path);
		SingletonInsert.getInsert().insert(citizens);
		return citizens;
	}

}

