package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class IdentifierExpresionTree extends AST {

    public IdentifierExpresionTree(Identifier iAST, Expression eAST, SourcePosition pos){
        super(pos);
        I = iAST;
        E = eAST;
    }

    public Identifier I;
    public Expression E;

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitIdentifierExpresionTree(this,o);
    }
}