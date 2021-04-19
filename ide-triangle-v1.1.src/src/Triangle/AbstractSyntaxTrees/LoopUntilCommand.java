/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;


public class LoopUntilCommand extends Command {
    
   public LoopUntilCommand (UntilCommand uAST, SourcePosition thePosition) {
    
        super (thePosition);
        U = uAST;
        
  }

  public Object visit(Visitor v, Object o) {
    return v.visitLoopUntilCommand(this, o);
  }
  
  public UntilCommand U;
  
}