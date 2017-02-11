package es.uniovi.asw.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import es.uniovi.asw.model.Citizen;

public class EmailGenerator {
	
	
	/**
	 * Metodo para generar un fichero en formato pdf/word segun se indique en la llamada que indique al usuario la contraseña y nombre de usuario que se le ha asignado
	 * @param formato "word" / "pdf" según de desee un formato u otro.
	 * @param usuario, ciudadano para el que se genera dicho documento
	 * @return documento creado con las especificaciones del usuario / null si no se ha podido crear el formato
	 */
	public File generate(String formato,Citizen usuario){
			if(!(formato.toLowerCase().equals("pdf") || formato.toLowerCase().equals("word"))){
				System.err.println("El formato elegido para crear el documento no existe.");
				return null;
				
			}
			
		      //Generamos un documento vacío
		      @SuppressWarnings("resource")
		      XWPFDocument document= new XWPFDocument(); 
		      //Guardamos el documento para poder hacer pruebas más adelante
		      try {
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
					"Contraseña: "+usuario.getPassword()); //Acordarse de traducir cuando esten las contraseñas cifradas!
					
;
					System.out.println("createdocument "+formato+" written successully");
		      } catch (IOException e) {
		    	  e.printStackTrace();
		    	  System.err.println("Error I/O en la generación del documento para el usuario "+usuario.getDNI());
		      }
		      if(formato.toLowerCase().equals("word")){
		    	    try {
		    	    	File send=new File("createdocument."+"docx");
		    	    	FileOutputStream out= new FileOutputStream( send);
						document.write(out);
						out.close();
						return send;
					} catch (IOException e) {
						e.printStackTrace();
				    	  System.err.println("Error I/O en la generación del documento word para el usuario "+usuario.getDNI());
					}
				}
			  if(formato.toLowerCase().equals("pdf")){
					try {
						File send=new File("createdocument."+"pdf");
						FileOutputStream out= new FileOutputStream(send );
						document.write(out);
						out.close();
						return send;
					} catch (IOException e) {
						e.printStackTrace();
				    	  System.err.println("Error I/O en la escritura del documento pdf para el usuario "+usuario.getDNI());
					}
			  }
			  return null;
	}

	
	
}
