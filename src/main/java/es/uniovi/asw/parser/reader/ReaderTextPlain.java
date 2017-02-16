package es.uniovi.asw.parser.reader;

import java.io.BufferedReader;
import java.io.FileReader;

import es.uniovi.asw.logger.Log;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;
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
        	
        	String siguiente = b.readLine();
        	int fila = 1;
        	while (siguiente != null) {
        		row = siguiente.split(";");
        		name = Checker.name(row[0], fila, 1, path);
        		surname = Checker.surname(row[1], fila, 2, path);
        		mail = Checker.mail(row[2], fila, 3, path);
        		//date = Checker.date(date, fila, 4, path);
        		address = Checker.address(row[4], fila, 5, path);
        		nationality = Checker.nationality(row[5], fila, 6, path);
        		dni = Checker.dni(row[6], fila, 7, path);
        		
        		username = Generator.username(name, mail);
				password = Generator.password(10,fila*1000);
				
				citiziens.add(new Citizen(name, surname, mail, date, address, 
						nationality, dni, username, password));
				
				siguiente = b.readLine();
				fila++;
        	}
        } catch (BusinessException e) {
        	Log.getInstance().warning(e.getMessage());
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
	}

}
