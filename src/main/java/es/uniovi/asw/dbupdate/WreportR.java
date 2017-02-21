package es.uniovi.asw.dbupdate;

import es.uniovi.asw.reportwriter.Log;
import es.uniovi.asw.reportwriter.WriteReport;

public class WreportR implements WriteReport{

	@Override
	public void report(String... errors) {
		
		Log.info(errors);
	}

}
