package es.uniovi.asw;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoadUsersTest {



private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
private  LoadUsers loader;

@Before
public void cargar() {
	loader=new LoadUsers();
}

@Before
public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
}

@After
public void cleanUpStreams() {
    System.setOut(null);
    System.setErr(null);
}

@SuppressWarnings("static-access")
@Test
public  void comprobarAy() {
	loader.main("-help");
	assertTrue(outContent.toString().contains("-h"));
    assertTrue(outContent.toString().contains("-r"));
    assertTrue(outContent.toString().contains("-w"));
}
@SuppressWarnings("static-access")
@Test
public  void comprobarRe() {
	loader.main("-read","test.xlsx");
	assertTrue(outContent.toString().contains("--- Cargando los datos del archivo ---"));
}
@SuppressWarnings("static-access")
@Test
public  void comprobarWr() {
	loader.main("-read", "-w xml","test.xlsx");
	assertTrue(outContent.toString().contains("No soportamos ese formato para las cartas"));
}
}
