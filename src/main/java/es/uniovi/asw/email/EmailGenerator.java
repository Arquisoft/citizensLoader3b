package es.uniovi.asw.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.util.Console;
import es.uniovi.asw.util.MD5;

public class EmailGenerator {
	
	public void generate(String formato, List<Citizen> citizens) {
		for (Citizen c: citizens)
			generateF(formato, c);
	}
	
	/**
	 * Metodo para generar un fichero en formato pdf/word segun se indique en la llamada que indique al usuario la contraseña y nombre de usuario que se le ha asignado
	 * @param formato "word" / "pdf" según se desee un formato u otro.
	 * @param usuario, ciudadano para el que se genera dicho documento
	 * @return documento creado con las especificaciones del usuario / null si no se ha podido crear el formato
	 */
	public static File generateF(String formato,Citizen usuario){
			if(usuario==null || usuario.getNombre()==null || usuario.getApellidos()==null 
					|| usuario.getDNI()==null || usuario.getEmail()==null){
				Console.println("El usuario es null o alguno de los parametros necesarios para realizar esta accion lo es. ");
				return null;
			}
			if(!(formato.equalsIgnoreCase("pdf") || formato.equalsIgnoreCase("word"))){
				Console.println("El formato elegido para crear el documento no existe.");
				return null;
			}
		      //Generamos un documento vacío
		      XWPFDocument document= new XWPFDocument(); 
		      //Guardamos el documento para poder hacer pruebas más adelante
		      try {
		    	  //Le asignamos un template para evitarnos los problemas de conversión a pdf más adelante
		    	    document = new XWPFDocument(new FileInputStream("template.docx"));
					//Creamos un primer parrafo que hará de título y lo asignamos al run.
					XWPFParagraph paragraph = document.createParagraph();
					XWPFRun run=paragraph.createRun();
					//Le damos color y aumentamos su tamaño.
					run.setFontSize(20);
					run.setColor("2E3B0B");
					run.setText("Portal de Participación Ciudadana");
					
					//Insertamos una imagen representativa de la asignatura.
					java.io.InputStream image=new FileInputStream("ASW.png");
					try {
						run.addPicture(image, Document.PICTURE_TYPE_PNG, "ASW",  Units.toEMU(100), Units.toEMU(100));
					} catch (InvalidFormatException e) {
						e.printStackTrace();
					}
					//Insertamos otros dos parrafos donde nos comunicamos con el usuario para darle su usuario y contraseña.
					paragraph = document.createParagraph();
					run=paragraph.createRun();
					run.setText(usuario.getNombre()+usuario.getApellidos()+
							", ha sido correctamente añadido al Portal de Participación Ciudadana.");
					//Último parrafo separado para darle un formato diferente con los bordes.
					paragraph = document.createParagraph();
					paragraph.setAlignment(ParagraphAlignment.CENTER);
					paragraph.setBorderBottom(Borders.BASIC_BLACK_DASHES);
					paragraph.setBorderLeft(Borders.BASIC_BLACK_DASHES);
					paragraph.setBorderRight(Borders.BASIC_BLACK_DASHES); 
					paragraph.setBorderTop(Borders.BASIC_BLACK_DASHES);
					run=paragraph.createRun();
					run.setText("Usuario: "+usuario.getUsuario()+" -------------- "+
					"Contraseña: "+MD5.desencriptar(usuario.getPassword())); //Acordarse de traducir cuando esten las contraseñas cifradas!
					//System.out.println("createdocument "+formato+" written successully");
		      } catch (IOException e) {
		    	  e.printStackTrace();
		    	  System.err.println("Error I/O en la generación del documento para el usuario "+usuario.getDNI());
		      } catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error al desencriptar la contraseña del usuario "+usuario.getDNI());
			}
	    	    	File sendword=new File("EmailGenerados/"+usuario.getDNI()+".docx");
	    	    	FileOutputStream out;
					try {
						out = new FileOutputStream(sendword);
						document.write(out);
						out.close();	
						document.close();
					} catch (IOException e) {
						e.printStackTrace();
						System.err.println("Error IO al genetat el docx");
					}
		
		      if(formato.equalsIgnoreCase("word")){
		    	  return sendword;
				}
		      else if(formato.equalsIgnoreCase("pdf")){
						try {
							File pdf= crearPdf(sendword,usuario.getDNI());
							sendword.delete();
							return pdf;
						} catch (IOException e) {
							e.printStackTrace();
							System.err.println("Error IO al genetat el pdf");
						}
			  }
			  return null;
	}
	
	
	/**
	 * Metodo para pasar docx a pdf por medio del PdfConverter de POI
	 * @param docx de referencia para crear el pdf
	 * @return file en formato pdf creado
	 * @throws IOException
	 */
	public static File crearPdf(File docx, String DNI) throws IOException{
		FileInputStream filew;
		File pdf=new File("EmailGenerados/"+DNI+".pdf");
		OutputStream outp = new FileOutputStream(pdf);
		try {
			filew = new FileInputStream(docx);
			XWPFDocument document = new XWPFDocument(filew);
			document.createStyles();
			PdfOptions options = PdfOptions.create();
	    	
	    	PdfConverter.getInstance().convert(document, outp, options);
	    	
	    	document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		outp.close();
		return pdf;
	}

	
	
}
