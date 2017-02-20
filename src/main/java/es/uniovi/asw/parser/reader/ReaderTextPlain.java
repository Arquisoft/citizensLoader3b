package es.uniovi.asw.parser.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.Reader;
import es.uniovi.asw.reportwriter.SingletonReporter;
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
        		
        		try {
        			
	        		row = siguiente.split(";");
	        		name = Checker.name(row[0], fila, 1, path);
	        		surname = Checker.surname(row[1], fila, 2, path);
	        		mail = Checker.mail(row[2], fila, 3, path);
	        		date = Checker.date(convertDate(row[3]), fila, 4, path);
	        		address = Checker.address(row[4], fila, 5, path);
	        		nationality = Checker.nationality(row[5], fila, 6, path);
	        		dni = Checker.dni(row[6], fila, 7, path);
	        		
	        		username = Generator.username(name, mail);
					password = Generator.password(10,fila*1000);
					
					Citizen c = new Citizen(name, surname, mail, date, address, 
							nationality, dni, username, password);
					
					citiziens.add(c);
					
					Console.println("Se ha añadido a la base de datos a "+c.toString());
				
        		} catch (BusinessException e) {
        			SingletonReporter.getWreportP().report(e.getMessage());
        			Console.println("ERROR al cargar uno de los ciudadano del fichero (informacion en Log.log)");
        		}
        		siguiente = b.readLine();
				fila++;
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
	}
	
	private Date convertDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		return format.parse(date);
	}

}
