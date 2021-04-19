/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class LoopWhileCommand extends Command {
  
  public LoopWhileCommand (WhileCommand wAST, SourcePosition thePosition) {
    
      super (thePosition);
      W = wAST;
      
  }

  public Object visit(Visitor v, Object o) {
    return v.visitLoopWhileCommand(this, o);
  }
  
  
  public WhileCommand W;
}
