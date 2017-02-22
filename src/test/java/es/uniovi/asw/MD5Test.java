package es.uniovi.asw;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.util.Generator;
import es.uniovi.asw.util.MD5;

public class MD5Test {
	
	private String pass;
	private String encriptada;
	
    @Before
    public void setUp() {
        pass = Generator.password(10, 0);
        encriptada = MD5.encriptar(pass);
    }

	@Test
	public void testDesencriptar() throws Exception {
		assertEquals(MD5.desencriptar(encriptada),pass);
	}

	@Test
	public void testEncriptarAgain(){
		assertEquals(MD5.encriptar(pass), encriptada);
	}
}
