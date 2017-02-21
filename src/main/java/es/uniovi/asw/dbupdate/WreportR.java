package es.uniovi.asw.dbupdate;

import es.uniovi.asw.reportwriter.SingletonReporter;
import es.uniovi.asw.reportwriter.WriteReport;

public class WreportR implements WriteReport{

	@Override
	public void report(String... errors) {
		
		SingletonReporter.getWreportP().report(errors);
	}

}
