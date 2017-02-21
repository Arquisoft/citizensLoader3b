package es.uniovi.asw.parser.reader;

import java.io.File;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.Reader;
import es.uniovi.asw.parser.WreportR;
import es.uniovi.asw.util.Checker;
import es.uniovi.asw.util.Console;
import es.uniovi.asw.util.Generator;

public class ReaderExcel extends Reader {
	private Row row = null;
	
	@Override
	public void execute() {
		XSSFWorkbook wb;
		XSSFSheet sheet;
		Iterator<Row> iteratorRow;
		
		try {
			wb = new XSSFWorkbook(new File(path));
			sheet = wb.getSheetAt(0);
			iteratorRow = sheet.iterator();
			iteratorRow.next(); //nos saltamos los titulos
			int fila = 1;
			while (iteratorRow.hasNext()) {
				
				try {
				row = iteratorRow.next();
				name = Checker.name(getInfo(0),fila,1,path);
				surname = Checker.surname(getInfo(1),fila,2,path);
				mail = Checker.mail(getInfo(2), fila, 3, path);
				date = Checker.date(row.getCell(3).getDateCellValue(),fila,4,path);
				address = Checker.address(getInfo(4),fila,5,path);
				nationality = Checker.nationality(getInfo(5),fila,6,path);
				dni = Checker.dni(getInfo(6),fila,7,path);
				
				username = Generator.username(name, mail);
				password = Generator.password(10,fila*1000);
				
				Citizen citizien = new Citizen(name, surname, mail, date, address, 
						nationality, dni, username, password);
				citiziens.add(citizien);
				
				Console.println("Se ha leído de excel a "+citizien.toString());
				
				} catch (BusinessException e) {
					new WreportR().report(e.getMessage());
					Console.println("ERROR al cargar uno de los ciudadano del fichero (informacion en Log.log)");
				}
				
				fila++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getInfo(int pos) {
		return row.getCell(pos).getStringCellValue();
	}

}
