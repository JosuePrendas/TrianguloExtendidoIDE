/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class LoopCommandForUntil extends Command {

    public LoopCommandForUntil(IdentifierExpresionTree ieAST, Expression e1AST,
                               UntilCommand uAST, SourcePosition thePosition) {
    
      super (thePosition);
      IE = ieAST;
      E1 = e1AST;
      U = uAST;
      
  }

  public Object visit(Visitor v, Object o) {
    return v.visitLoopCommandForUntil(this, o);
  }
  
  public UntilCommand U;
  public Expression E1;
  public IdentifierExpresionTree IE;
}