/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PrivateDeclaration extends Declaration{
    
    public PrivateDeclaration (Declaration pfd1, Declaration pfd2, SourcePosition thePosition) {
    super (thePosition);
    PFD1 = pfd1;
    PFD2 = pfd2;
  }
    
   public Object visit(Visitor v, Object o) {
       return v.visitPrivateDeclaration(this, o);
    } 
   
  public Declaration PFD1, PFD2; 
    
}