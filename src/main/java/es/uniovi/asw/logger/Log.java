package es.uniovi.asw.logger;

import java.util.logging.*;

import org.apache.log4j.PropertyConfigurator;

public class Log {
	public static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	private Log (){
		PropertyConfigurator.configure("log4j.properties");
	};
	
	public static Logger getInstance() {
		return logger;
	}

}
