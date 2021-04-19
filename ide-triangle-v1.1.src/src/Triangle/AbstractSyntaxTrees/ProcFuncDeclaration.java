/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;


public class ProcFuncDeclaration extends Declaration {
    
    public ProcFuncDeclaration (ProcFuncDeclaration pfd1, ProcFuncDeclaration pfd2, SourcePosition thePosition) {
    super (thePosition);
    PFD1 = pfd1;
    PFD2 = pfd2;
  }

    public ProcFuncDeclaration(SourcePosition thePosition) {
        super(thePosition);
    }

    public Object visit(Visitor v, Object o) {
       return v.visitProcFuncDeclaration(this, o);
    } 
   
  public ProcFuncDeclaration PFD1, PFD2;
  
}