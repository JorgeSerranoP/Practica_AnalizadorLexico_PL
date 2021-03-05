package lex.manual; // paquete en el que creemos el archivo

public interface SimbolosTerminales {
	/* terminals */
	public static final int EOF = 0;
	public static final int error = 1;
	public static final int coma = 2;
	public static final int puntoYComa = 3;
	public static final int mas = 4;
	public static final int menos = 5;
	public static final int por = 6;
	public static final int entre = 7;
	public static final int parentesisI = 8;
	public static final int parentesisD = 9;
	public static final int numero = 10;
	public static final int numeroReal = 11;
	public static final int numeroHex = 12;
	public static final int nombreApellido = 13;
	public static final int email = 14;
	public static final int dni = 15;
	public static final int matricula = 16;
	public static final int  fecha = 17;

	/* lista de nombres, util para devolver información por pantalla */
	public static final String[] terminalNames = new String[] { "EOF", "error", "coma", "puntoYComa", "mas", "menos", "por",
			"entre", "parentesisI", "parentesisD", "numero", "numeroReal", "numeroHex", "nombreApellido", "email", "dni", "matricula", "fecha"
	};
}
