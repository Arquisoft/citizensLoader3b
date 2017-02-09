package es.uniovi.asw.parser.reader;

import java.io.File;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.Reader;
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
			
			while (iteratorRow.hasNext()) {
				row = iteratorRow.next();
				name = Checker.name(getInfo(0));
				surname = Checker.surname(getInfo(1));
				mail = Checker.mail(getInfo(2));
				date = Checker.date(row.getCell(3).getDateCellValue());
				address = Checker.address(getInfo(4));
				nationality = Checker.nationality(getInfo(5));
				dni = Checker.dni(getInfo(6));
				
				username = Generator.username(name, mail);
				password = Generator.password(10);
				
				citiziens.add(new Citizen(name, surname, mail, date, address, 
						nationality, dni, username, password));
			}
		} catch (Exception e) {
			Console.print(e.getMessage());
		}
	}
	
	public String getInfo(int pos) {
		return row.getCell(pos).getStringCellValue();
	}

}
