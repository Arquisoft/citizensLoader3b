package es.uniovi.asw.parser;

import es.uniovi.asw.reportwriter.WreportP;
import es.uniovi.asw.reportwriter.WriteReport;

public class WreportR implements WriteReport{

	@Override
	public void report(String... errors) {
		new WreportP().report(errors);
	}

}
