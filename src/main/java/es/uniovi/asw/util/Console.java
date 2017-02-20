package es.uniovi.asw.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Consola de albutil
 */
public class Console {
	protected static BufferedReader kbd = new BufferedReader(
			new InputStreamReader(System.in));
	

	public static void println(String string) {
		System.out.println(string);
	}

	public static void print(String string) {
		System.out.print(string);
	}

}
