package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class LongIdentifier extends AST {
    public LongIdentifier(Identifier i1AST, Identifier i2AST, SourcePosition thePosition){
        super(thePosition);
        I1 = i1AST;
        I2 = i2AST;
    }

    public LongIdentifier(Identifier i1AST, SourcePosition thePosition){
        super(thePosition);
        I2 = i1AST;
    }

    public Identifier I1,I2;

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitLongIdentifier(this,o);
    }
}