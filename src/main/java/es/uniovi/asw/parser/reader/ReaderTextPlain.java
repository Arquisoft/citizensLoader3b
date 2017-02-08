package es.uniovi.asw.parser.reader;

import java.io.BufferedReader;
import java.io.FileReader;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.Reader;
import es.uniovi.asw.util.Checker;
import es.uniovi.asw.util.Console;
import es.uniovi.asw.util.Generator;

public class ReaderTextPlain extends Reader{

	@Override
	public void execute() {
		FileReader f;
        BufferedReader b;
        
        try {
        	String[] row;
        	f = new FileReader(path);
        	b = new BufferedReader(f);
        	b.readLine(); //Me salto los indices
        	while ((row = b.readLine().split(";")) != null) {
        		name = Checker.name(row[0]);
        		surname = Checker.surname(row[1]);
        		mail = Checker.mail(row[2]);
        		//date = Checker.date(date);
        		address = Checker.address(row[4]);
        		nationality = Checker.nationality(row[5]);
        		dni = Checker.dni(row[6]);
        		
        		username = Generator.username(name, mail);
				password = Generator.password(10);
				
				citiziens.add(new Citizen(name, surname, mail, date, address, 
						nationality, dni, username, password));
        	}
        } catch (Exception e) {
        	Console.print("Ha ocurrido un error");
        }
		
	}

}
