package es.uniovi.asw;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.UnrecognizedOptionException;

import es.uniovi.asw.email.EmailGenerator;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.RList;
import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.reportwriter.Log;
import es.uniovi.asw.util.Console;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		Log.config();
		runner.run(args);
	}

	private void run(String... args) {
		Options options = new Options();
		Option help = new Option("h", "help", false, "Muestra la ayuda.");
		Option read = new Option("r", "read", false, "Lee el fichero");
		Option writer = Option.builder("w").hasArg().argName("formato").desc("Indica el formato de las cartas a generar, si no se usa este comando, no se generarán cartas.").build();
		options.addOption(help);
		options.addOption(read);
		options.addOption(writer);
		
		CommandLineParser cmd = new DefaultParser();
		
		try {
			CommandLine line = cmd.parse(options, args);
			
			if(line.hasOption("help")){
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp( "Citizens", options );
			}
			
			else if(line.hasOption("r")){
				
				Console.println("--- Cargando los datos del archivo ---");
				
				ReadList reader = new RList();
				String ruta = "src/test/resources/"+args[args.length-1];
				List<Citizen> citizens = reader.read(ruta);
				
				if(line.hasOption("w")){
					
					if(line.getOptionValue("w").toLowerCase().equals("pdf"))
						new EmailGenerator().generate("pdf", citizens);
					
					else if (line.getOptionValue("w").toLowerCase().equals("word"))
						new EmailGenerator().generate("word", citizens);
					
					else 
						System.out.println("No soportamos ese formato para las cartas");
							
				}
				
			}
			
			else if(line.getOptions().length == 0){
				System.out.println("Utiliza -help para ver la ayuda.");
			}
						
			Console.println("--- Finalizada la lectura del archivo ---");
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
