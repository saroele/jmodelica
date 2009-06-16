/*
    Copyright (C) 2009 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.jmodelica.ide.scanners.generated;

import java.io.IOException;
import java.io.StringReader;

import org.jmodelica.ide.editor.IndentationStrategy.Word;

%%

%public
%final
%class IndentationKeywordScanner
%unicode
%buffer 256
%type Word
%char
%table

%{
	Word res;
	
    public IndentationKeywordScanner() {
        this(new StringReader(""));
    }
    
    public Word findWord(String line, int type) {
        yyreset(new StringReader(line));
        yybegin(type);
        try {
			return yylex();
		} catch (IOException e) {
			return null;
		}
    }
    
    private Word createWord() {
        return new Word(yytext(), null, yychar);
    }
%}

NONDIGIT = [a-zA-Z_]
DIGIT = [0-9]
INTEGER = {DIGIT} {DIGIT}*
FRAC = "." ( {INTEGER} )?
EXP = (e|E) ( "+" | "-" )? {INTEGER}
NUMBER = ( {DIGIT}+ {FRAC}? | {FRAC} ) {EXP}?
NormId = {NONDIGIT} ({DIGIT}|{NONDIGIT})*
QIdent = "\'" ([^\'\\] | "\\" .)* "\'"
String = "\"" ([^\"\\] | "\\" .)* "\""
Id = {NormId} | {QIdent}
LineComment = "//" [^\n\r]*
TradComment = "/*" ~"*/"
WhiteSpace = [ \t]+
Operator = "(" | ")" | "{" | "}" | "[" | "]" | ";" | ":" | "." | "," | "+" | "-" | "*" | 
           "/" | "=" | "^" | "<" | "<=" | ">" | ">=" | "==" | "<>"
Ignore = {WhiteSpace} | {TradComment} | {Id} | {String} | {NUMBER} | {Operator}

IndentWordId =  "block" | "class" | "connector" | "function" | "model" | "package" | "record" | "type"
IndentWordEnd = "equation" | "algorithm" | "public" | "protected"
AdjustWordId =  "end"
AdjustWordEnd = {IndentWordEnd}

%state INDENT, ADJUST, ID

%%

<INDENT> {
  {IndentWordId}	{ res = createWord(); yybegin(ID); }
  {IndentWordEnd}	{ return createWord(); }
}

<ADJUST> {
  {AdjustWordId}	{ res = createWord(); yybegin(ID); }
  {AdjustWordEnd}	{ return createWord(); }
}

<INDENT, ADJUST> {
  {Ignore}			{ }
  .					{ }
  {LineComment}		{ return null; }
  <<EOF>>			{ return null; }
}

<ID> {
  {Id}				{ res.id = yytext(); return res; }
  {WhiteSpace}		{ }
  .					{ return res; }
  <<EOF>>			{ return res; }
}