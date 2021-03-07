package lex.generado; // paquete en el que se genera el fichero java
import lex.manual.SimbolosTerminales; //Simbolos terminales definidos
import lex.manual.Symbol;

%%

%class Lexer
%implements SimbolosTerminales
%public
%unicode

%line
%column
%char

%function next_token // Nombre del método que escanea la entrada y
 // devuelve el siguiente token
%type Symbol // Tipo de retorno para la función de scan


%eofval{
 return new Symbol(EOF);
%eofval}


/* Macros para expresiones regulares (para simplificar reglas) */
Newline    = \r | \n | \r\n
Whitespace = [ \t\f] | {Newline}
Number     = [0-9]+
RealNumber = [0-9]*\.?[0-9]+([eE][-+]?[0-9]+)?
HexNumber  = "0X"[0-9|A-F]+
NameSurname = [A-Z][a-z]*
Email = [A-Za-z0-9]+@[A-Za-z0-9]+\.[A-Za-z]{2}[A-Za-z]*
Dni = [0-9]{8}[A-Z]
CarRegistration = [0-9]{4}[A-Z]{3}
Date = (3[01]|[12][0-9]|0[1-9])\/(1[0-2]|0[1-9])\/[0-9]{4}

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*


%%

/* Reglas para detectar los tokens y acciones asociadas */
<YYINITIAL> {
  {Whitespace}		{ }
  ";"          		{ return new Symbol(puntoYComa, yytext()); }
  "+"          		{ return new Symbol(mas, yytext()); }
  "-"          		{ return new Symbol(menos, yytext()); }
  "*"          		{ return new Symbol(por, yytext()); }
  "/"          		{ return new Symbol(entre, yytext()); }
  "("          		{ return new Symbol(parentesisI, yytext()); }
  ")"          		{ return new Symbol(parentesisD, yytext()); }
  {Number}     		{ return new Symbol(numero, yytext());}
  {RealNumber}      { return new Symbol(numeroReal, yytext());}
  {HexNumber}       { return new Symbol(numeroHex, yytext());}
  {NameSurname}   	{ return new Symbol(nombreApellido, yytext());}
  {Email}   		{ return new Symbol(email, yytext());}
  {Dni}   			{ return new Symbol(dni, yytext());}
  {CarRegistration} { return new Symbol(matricula, yytext());}
  {Date}   			{ return new Symbol(fecha, yytext());}  
  {Comment}    		{ }
}

// error fallback
.|\n 	{System.err.println("warning: Unrecognized character '"
		 + yytext()+"' -- ignored" + " at : "+ (yyline+1) + " " +
		 (yycolumn+1) + " " + yychar); }
