/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;
public class LoopCommandForWhile extends Command {

  public LoopCommandForWhile(IdentifierExpresionTree ieAST, Expression e1AST,
                             WhileCommand wAST, SourcePosition thePosition) {

    super (thePosition);
    IE = ieAST;
    E1 = e1AST;
    W = wAST;

  }

  public Object visit(Visitor v, Object o) {
    return v.visitLoopCommandForWhile(this, o);
  }

  public WhileCommand W;
  public Expression E1;
  public IdentifierExpresionTree IE;

}