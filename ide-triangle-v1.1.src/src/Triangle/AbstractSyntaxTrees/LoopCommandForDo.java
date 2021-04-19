/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;


public class LoopCommandForDo extends Command {
    
    public LoopCommandForDo (IdentifierExpresionTree ieAST,
            Expression eAST, Command c1AST, SourcePosition thePosition) {
    
      super (thePosition);
      IE = ieAST;
      E1 = eAST;
      C1 = c1AST;
      
  }

  public Object visit(Visitor v, Object o) {
    return v.visitLoopCommandForDo(this, o);
  }
  
  
  public Expression E1;
  public Command C1;
  public IdentifierExpresionTree IE;
    
}