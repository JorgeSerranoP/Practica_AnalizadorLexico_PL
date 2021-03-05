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
RealNumber = [-+]?[0-9]*.?[0-9]+([eE][-+]?[0-9]+)?
HexNumber  = "0X"[0-9|A-F]+
Identificator = [a-zA-Z\s][a-zA-Z0-9]*

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*


%%

/* Reglas para detectar los tokens y acciones asociadas */
<YYINITIAL> {
  {Whitespace}		{ }
  ","          		{ return new Symbol(coma); }
  ";"          		{ return new Symbol(puntoYComa); }
  "+"          		{ return new Symbol(mas); }
  "-"          		{ return new Symbol(menos); }
  "*"          		{ return new Symbol(por); }
  "/"          		{ return new Symbol(entre); }
  "("          		{ return new Symbol(parentesisI); }
  ")"          		{ return new Symbol(parentesisD); }
  {Number}     		{ return new Symbol(numero, yytext());}
  {RealNumber}      { return new Symbol(numeroReal, yytext());}
  {HexNumber}       { return new Symbol(numeroHex, yytext());}
  {Identificator}   { return new Symbol(identificador, yytext());}
  {Comment}    		{ }
}

// error fallback
.|\n 	{System.err.println("warning: Unrecognized character '"
		 + yytext()+"' -- ignored" + " at : "+ (yyline+1) + " " +
		 (yycolumn+1) + " " + yychar); }
