package lex.manual; // paquete en el que creemos el archivo

public interface SimbolosTerminales {
	/* terminals */
	public static final int EOF = 0;
	public static final int error = 1;
	public static final int puntoYComa = 2;
	public static final int mas = 3;
	public static final int menos = 4;
	public static final int por = 5;
	public static final int entre = 6;
	public static final int parentesisI = 7;
	public static final int parentesisD = 8;
	public static final int numero = 9;
	public static final int numeroReal = 10;
	public static final int numeroHex = 11;
	public static final int nombreApellido = 12;
	public static final int email = 13;
	public static final int dni = 14;
	public static final int matricula = 15;
	public static final int fecha = 16;

	/* lista de nombres, util para devolver información por pantalla */
	public static final String[] terminalNames = new String[] { "EOF", "error", "puntoYComa", "mas", "menos", "por",
			"entre", "parentesisI", "parentesisD", "numero", "numeroReal", "numeroHex", "nombreApellido", "email",
			"dni", "matricula", "fecha" };
}
