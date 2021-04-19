package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PackageDeclaration extends PackageDeclarationTree {
    public PackageDeclaration(Identifier iAST, Declaration dAST, SourcePosition declarationPos){
        super(declarationPos);
        I = iAST;
        D = dAST;
    }

    public Identifier I;
    public Declaration D;

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitPackageDeclaration(this,o);
    }
}