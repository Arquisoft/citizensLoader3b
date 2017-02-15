package es.uniovi.asw;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.UnrecognizedOptionException;

import es.uniovi.asw.dbupdate.AddCitizen;
import es.uniovi.asw.dbupdate.CommandExecutor;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.RList;
import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.parser.reader.ReaderExcel;
import es.uniovi.asw.parser.reader.ReaderTextPlain;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		runner.run(new String[]{"-e", "src/test/resources/test.xlsx"});
	//	runner.run();
	}

	private void run(String... args) {
		Options options = new Options();
		Option help = new Option("h", "help", false, "Muestra la ayuda.");
		Option reader = Option.builder("e").hasArg().argName("tipo").desc("Indica que el tipo de archivo a cargar será xls (Excel).").build();
		Option reader2 = Option.builder("t").hasArg().argName("tipo2").desc("Indica que el tipo de archivo a cargar será txt (texto plano).").build();
		Option writer = Option.builder("w").hasArg().argName("formato").desc("Indica el formato de las cartas a generar, si no se usa este comando, no se generarán cartas.").build();
		options.addOption(help);
		options.addOption(reader);
		options.addOption(reader2);
		options.addOption(writer);
		
		CommandLineParser cmd = new DefaultParser();
		CommandExecutor executor = new CommandExecutor();
		try {
			CommandLine line = cmd.parse(options, args);
			
			if(line.hasOption("help")){
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp( "Citizens", options );
			}
			else if(line.hasOption("e")){
				
				System.out.println("Se cargarán los datos del archivo excel.");
				ReaderExcel excel = null;
				String ruta = line.getOptionValue("e");
				if(line.hasOption("w")){
					if(line.getOptionValue("w").toLowerCase().equals("pdf")){
						//leer excel y generar cartas pdf
					}
					else{
						//un if con el resto de formatos y en el excel el formato por defecto si no se especifica uno
					}
				}
				else{
					excel = new ReaderExcel(); //--> esto ya se hace en el rlist...
				}
				List<Citizen> ciudadanos=excel.readFile(ruta);
				if(ciudadanos != null){
					
					for (Citizen c: ciudadanos)
						executor.execute(new AddCitizen(c));
					System.out.println("Ciudadanos cargados con exito.");
				}
				else{
					System.out.println("Ha habido un problema al cargar el excel.");
				}
			}
			else if(line.hasOption("t")){
				System.out.println("Se cargarán los datos del archivo txt.");
				ReaderTextPlain txt = null;
				String ruta = line.getOptionValue("t");
				if(line.hasOption("w")){
					if(line.getOptionValue("w").toLowerCase().equals("pdf")){
						//leer txt y generar cartas pdf
					}
					else{
						//un if con el resto de formatos y en el excel el formato por defecto si no se especifica uno
					}
				}
				else{
					txt = new ReaderTextPlain(); //--> esto ya se hace en el rlist...
				}
				List<Citizen> ciudadanos=txt.readFile(ruta);
				if(ciudadanos != null){
					
					for (Citizen c: ciudadanos)
						executor.execute(new AddCitizen(c));
					
					System.out.println("Ciudadanos cargados con exito.");
				}
				else{
					System.out.println("Ha habido un problema al cargar el excel.");
				}
			}
			else if(line.getOptions().length == 0){
				System.out.println("Utiliza -help para ver la ayuda.");
			}
						
			
		} catch (UnrecognizedOptionException e) {
			System.out.println("No se reconoce esa entrada, utliza -help para ver la ayuda.");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	// TODO
//	void run(String... args) {
//		System.out.println("TODO");
//		CommandExecutor executor = new CommandExecutor();
//		ReadList r = new RList();
//		try {
//			List<Citizen> ciudadanos = r.read("src/test/resources/test.xlsx");
//			
//			for (Citizen c: ciudadanos)
//				executor.execute(new AddCitizen(c));
//			
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
	
	
}
