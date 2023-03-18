package parser;
import java_cup.runtime.Symbol;

%%

%class Scanner
%cup
%public
%line
%column
%unicode
%ignorecase

%init{
  yyline = 1;
  yycolumn = 1;
%init}

%{
  private Symbol ssymbol(int type){
      //System.out.println(yytext());
      return new Symbol(type, yyline, yycolumn, yytext());
  }
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = [ \t\f]
SingleComment = "//" {InputCharacter}* {LineTerminator}?
MultiComment = "<!" [^!] ~"!>"
Comment = {SingleComment}|{MultiComment}
String = [\"]([^\"\n]|[^\\\"])*[\"]
// Identifier = [a-zA-Z]["_"0-9A-Za-z]*
Identifier = ([a-zA-Z]|[0-9]|_)+
NewLine = (\\n)
Apostrophe = (\\')
Quotes  =(\\\")
LowerCase = [a-z]
UpperCase = [A-Z]
Number = [0-9]+
Ascii = [\32-\125]

%%

<YYINITIAL> {
    {WhiteSpace}      {}
    {Comment}         {}    
    {LineTerminator}  {yycolumn = 1;}
    "CONJ"            {return ssymbol(sym.CONJ);} 
    ":"               {return ssymbol(sym.COLON);}
    "-"               {return ssymbol(sym.HYPHEN);}
    ">"               {return ssymbol(sym.GREATER);}
    ";"               {return ssymbol(sym.SEMICOLON);}
    "%%"              {return ssymbol(sym.SEPARATOR);}
    "{"               {return ssymbol(sym.LBRACKET);}
    "}"               {return ssymbol(sym.RBRACKET);}
    "~"               {return ssymbol(sym.TILDE);}
    ","               {return ssymbol(sym.COMMA);}

    "+"               {return ssymbol(sym.ITERATION);}
    "*"               {return ssymbol(sym.KLEENE);}
    "."               {return ssymbol(sym.CONCAT);}
    "|"               {return ssymbol(sym.UNION);}
    "?"               {return ssymbol(sym.OPTION);}

    {LowerCase}       {return ssymbol(sym.LOWERC);}
    {UpperCase}       {return ssymbol(sym.UPPERC);}
    {Number}          {return ssymbol(sym.NUMBER);}
    {Identifier}      {return ssymbol(sym.IDENTIFIER);}
    {Quotes}          {return ssymbol(sym.QUOTES);}
    {Apostrophe}      {return ssymbol(sym.APOSTROPHE);}
    {NewLine}         {return ssymbol(sym.NEWLINE);}
    {String}          {return ssymbol(sym.STRING);}
    {Ascii}           {return ssymbol(sym.ASCII);}
}

.                     {throw new Error("Illegal character: "+yytext()+" at ("+yyline+", "+yycolumn+")");}
