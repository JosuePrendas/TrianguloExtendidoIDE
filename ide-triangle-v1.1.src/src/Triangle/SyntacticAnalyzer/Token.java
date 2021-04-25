/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    ARRAY		= 4,
    CHOOSE      = 5, ///Nuevo token agregado
    CONST		= 6,
    DO			= 7,
    ELSE		= 8,
    ELSIF       = 9,///Nuevo token agregado
    END			= 10,
    FOR         = 11,///Nuevo token agregado
    FROM        = 12,///Nuevo token agregado
    FUNC		= 13,
    IF			= 14,
    IN			= 15,
    LET			= 16,
    LOOP        = 17,///Nuevo token agregado
    NOTHING     = 18,///Nuevo token agregado
    OF			= 19,
    PACKAGE     = 20,///Nuevo token agregado
    PRIVATE     = 21,///Nuevo token agregado
    PROC		= 22,
    RECORD		= 23,
    RECURSIVE   = 24,///Nuevo token agregado
    THEN		= 25,
    TO          = 26,///Nuevo token agregado
    TYPE		= 27,
    UNTIL       = 28,///Nuevo token agregado
    VAR			= 29,
    WHEN        = 30,///Nuevo token agregado
    WHILE		= 31,

    // punctuation...
    OR          = 32,///Nuevo token agregado
    DOLAR       = 33,///Nuevo token agregado
    DOTDOT      = 34,///Nuevo token agregado
    DOT			= 35,
    COLON		= 36,
    SEMICOLON	= 37,///Nuevo token agregado
    COMMA		= 38,
    BECOMES		= 39,
    IS			= 40,

    // brackets...
    LPAREN		= 41,
    RPAREN		= 42,
    LBRACKET	= 43,///Nuevo token agregado
    RBRACKET	= 44,///Nuevo token agregado
    LCURLY		= 45,
    RCURLY		= 46,

    // special tokens...
    EOT			= 47,
    ERROR		= 48;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    "choose",///Nuevo token agregado
    "const",
    "do",
    "else",
    "elsif",///Nuevo token agregado
    "end",
    "for",///Nuevo token agregado
    "from",///Nuevo token agregado
    "func",
    "if",
    "in",
    "let",
    "loop",///Nuevo token agregado
    "nothing",///Nuevo token agregado
    "of",
    "package",///Nuevo token agregado
    "private",///Nuevo token agregado
    "proc",
    "record",
    "recursive",///Nuevo token agregado
    "then",
    "to",///Nuevo token agregado
    "type",
    "until",///Nuevo token agregado
    "var",
    "when",///Nuevo token agregado
    "while",
    "|",
    "$",///Nuevo token agregado
    "..",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"
  };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;



  //funcion para verificar que es una palabra reservada, retorna boolean
  public static boolean isReservedWord(String token) {
    boolean answer = false;
    for(int i = 4;i<30;i++) { //asegurar que concuerde
      if(tokenTable[i].equals(token)) {
        answer = true;
        break;
      }
    }
    return answer;
  }

}