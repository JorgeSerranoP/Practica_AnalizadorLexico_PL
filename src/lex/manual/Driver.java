package lex.manual;

import lex.generado.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Driver {
	public static void main(String args[]) throws IOException {
		// Entrada de datos: teclado por defecto, fichero si hay argumento
		// InputStream dataStream = System.in;
		FileInputStream dataStream = new FileInputStream(args[0]);
		System.out.println("Leyendo entrada de fichero... ");
		InputStreamReader isr = new InputStreamReader(dataStream, "utf8");
		BufferedReader br = new BufferedReader(isr);

		String linea;
		int lineas = 0;
		int caracteres = 0;
		while ((linea = br.readLine()) != null) {
			lineas++;
			caracteres += linea.length();
		}

		FileInputStream dataStream1 = new FileInputStream(args[0]);
		// Creamos el objeto scanner
		Lexer scanner = new Lexer(dataStream1);
		ArrayList<Symbol> operadores = new ArrayList<Symbol>();
		ArrayList<Symbol> separadores = new ArrayList<Symbol>();
		ArrayList<Symbol> numeros = new ArrayList<Symbol>();
		ArrayList<Symbol> nombres = new ArrayList<Symbol>();
		ArrayList<Symbol> emails = new ArrayList<Symbol>();
		ArrayList<Symbol> DNIs = new ArrayList<Symbol>();
		ArrayList<Symbol> matriculas = new ArrayList<Symbol>();
		ArrayList<Symbol> fechas = new ArrayList<Symbol>();

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
				} else if (token.type() == 12) {
					nombres.add(token);
				} else if (token.type() == 13) {
					emails.add(token);
				} else if (token.type() == 14) {
					DNIs.add(token);
				} else if (token.type() == 15) {
					matriculas.add(token);
				} else if (token.type() == 16) {
					fechas.add(token);
				}
			} catch (Exception x) {
				System.out.println("Ups... algo ha ido mal");
				x.printStackTrace();
			}
		}
		operadores.trimToSize();
		separadores.trimToSize();
		numeros.trimToSize();
		nombres.trimToSize();
		emails.trimToSize();
		DNIs.trimToSize();
		matriculas.trimToSize();
		fechas.trimToSize();
		System.out.println("OPERADORES: ");
		if (operadores.isEmpty()) {
			System.out.println("No se han encontrado operadores");
		} else {
			for (int i = 0; i < operadores.size(); i++) {
				System.out.print(operadores.get(i).value());
			}
			System.out.println();
		}
		System.out.println("SEPARADORES Y PARENTESIS: : ");
		if (separadores.isEmpty()) {
			System.out.println("No se han encontrado separadores ni parentesis");
		} else {
			for (int i = 0; i < separadores.size(); i++) {
				System.out.print(separadores.get(i).value());
			}
			System.out.println();
		}
		System.out.println("NUMEROS: ");
		if (numeros.isEmpty()) {
			System.out.println("No se han encontrado numeros");
		} else {
			for (int i = 0; i < numeros.size(); i++) {
				System.out.print(numeros.get(i).value() + " ");
			}
			System.out.println();
		}
		System.out.println("IDENTIFICADORES: ");
		System.out.print("Nombre y apellidos: ");
		if (nombres.isEmpty()) {
			System.out.println("No se han encontrado nombres");
		} else {
			for (int i = 0; i < nombres.size(); i++) {
				System.out.print(nombres.get(i).value() + ", ");
			}
			System.out.println();
		}
		System.out.print("Email: ");
		if (emails.isEmpty()) {
			System.out.println("No se han encontrado emails");
		} else {
			for (int i = 0; i < emails.size(); i++) {
				System.out.print(emails.get(i).value() + ", ");
			}
			System.out.println();
		}
		System.out.print("DNI: ");
		if (DNIs.isEmpty()) {
			System.out.println("No se han encontrado DNIs");
		} else {
			for (int i = 0; i < DNIs.size(); i++) {
				System.out.print(DNIs.get(i).value() + ", ");
			}
			System.out.println();
		}
		System.out.print("Matricula: ");
		if (matriculas.isEmpty()) {
			System.out.println("No se han encontrado matriculas");
		} else {
			for (int i = 0; i < matriculas.size(); i++) {
				System.out.print(matriculas.get(i).value() + ", ");
			}
			System.out.println();
		}
		System.out.print("Fecha: ");
		if (fechas.isEmpty()) {
			System.out.println("No se han encontrado nombres");
		} else {
			for (int i = 0; i < fechas.size(); i++) {
				System.out.print(fechas.get(i).value() + ", ");
			}
			System.out.println();
		}
		System.out.println("EXTENSION: ");
		System.out.println("Numero de lineas: " + lineas);
		System.out.println("Numero de caracteres: " + caracteres);
		int simbolos = operadores.size() + separadores.size() + numeros.size()
		+ nombres.size() + emails.size() + DNIs.size() + matriculas.size() + fechas.size();
		System.out.println("Numero de simbolos: " + simbolos);

		System.out.println("\n\n -- Bye-bye -- ");
	}
}
