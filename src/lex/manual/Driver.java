package lex.manual;

import lex.generado.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

class Driver {
	public static void main(String args[]) throws IOException {
		// Entrada de datos: teclado por defecto, fichero si hay argumento
		InputStream dataStream = System.in;
		if (args.length >= 1) {
			System.out.println("Leyendo entrada de fichero... ");
			dataStream = new FileInputStream(args[0]);
		} else {
			System.out.println("Inserta expresiones a reconocer," + " pulsando <ENTER> entre ellas");
		}
		// Creamos el objeto scanner
		Lexer scanner = new Lexer(dataStream);
		ArrayList<Symbol> operadores = new ArrayList<Symbol>();
		ArrayList<Symbol> separadores = new ArrayList<Symbol>();
		ArrayList<Symbol> numeros = new ArrayList<Symbol>();
		ArrayList<Symbol> identificadores = new ArrayList<Symbol>();

		// Mientras no alcancemos el fin de la entrada
		boolean end = false;

		while (!end) {
			try {
				Symbol token = scanner.next_token();
				end = (token.value() == null);
				if (token.type() == 3 || token.type() == 4 || token.type() == 5 || token.type() == 6) {
					operadores.add(token);
				} else if (token.type() == 2 || token.type() == 7 || token.type() == 8) {
					separadores.add(token);
				} else if (token.type() == 9 || token.type() == 10 || token.type() == 11) {
					numeros.add(token);
				} else if (token.type() == 12 || token.type() == 13 || token.type() == 14 || token.type() == 15
						|| token.type() == 16) {
					identificadores.add(token);
				}
			} catch (Exception x) {
				System.out.println("Ups... algo ha ido mal");
				x.printStackTrace();
			}
		}
		operadores.trimToSize();
		separadores.trimToSize();
		numeros.trimToSize();
		identificadores.trimToSize();
		System.out.println("OPERADORES: ");
		if (operadores.isEmpty()) {
			System.out.println("No se han encontrado operadores");
		} else {
			for (int i = 0; i < operadores.size(); i++) {
				System.out.print(operadores.get(i).value());
			}
		}
		System.out.println();
		System.out.println("SEPARADORES Y PARENTESIS: : ");
		if (separadores.isEmpty()) {
			System.out.println("No se han encontrado separadores ni parentesis");
		} else {
			for (int i = 0; i < separadores.size(); i++) {
				System.out.print(separadores.get(i).value());
			}
		}
		System.out.println();
		System.out.println("NUMEROS: ");
		if (numeros.isEmpty()) {
			System.out.println("No se han encontrado numeros");
		} else {
			for (int i = 0; i < numeros.size(); i++) {
				System.out.print(numeros.get(i).value() + " ");
			}
		}
		System.out.println();
		System.out.println("IDENTIFICADORES: ");
		if (identificadores.isEmpty()) {
			System.out.println("No se han encontrado identificadores");
		} else {
			for (int i = 0; i < identificadores.size(); i++) {
				System.out.print(identificadores.get(i).value());
			}
		}
		System.out.println();
		System.out.println("EXTENSION: ");
		System.out.print(operadores.size() + separadores.size() + numeros.size() + identificadores.size());

		System.out.println("\n\n -- Bye-bye -- ");
	}
}
