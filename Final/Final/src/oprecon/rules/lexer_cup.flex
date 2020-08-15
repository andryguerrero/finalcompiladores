package oprecon;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
NEW_LINE = [\n]
TAB = [\t]
%{
    private Symbol symbol(int type, Object value) {
    	return new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol symbol(int type) {
    	return new Symbol(type, yyline, yycolumn);
    }
%}
%%

{NEW_LINE} {return new Symbol(sym.NEW_LINE_SPACE, yychar, yyline, yytext());}

{TAB} {return new Symbol(sym.TAB_SPACE, yychar, yyline, yytext());}

(A|B|C|D|F) {return new Symbol(sym.LITERAL, yychar, yyline, yytext());}

([0-9])+((\.)([0-9])+)? {return new Symbol(sym.CALIFICATION, yychar, yyline, yytext());}

 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
