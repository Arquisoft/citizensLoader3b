package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.reader.ReaderExcel;
import es.uniovi.asw.parser.reader.ReaderTextPlain;
import es.uniovi.asw.util.Console;

public class RList implements ReadList {
	
	private Reader reader;
	
	@Override
	public List<Citizen> read(String path) {
		String extension = path.split("\\.")[1];
		
		if (extension.equals("xlsx"))
			reader = new ReaderExcel();
		else if (extension.equals("txt"))
			reader = new ReaderTextPlain();
		else
			Console.print("El fichero no tiene un formato correcto");
		
		return reader.readFile(path);
	}

}
