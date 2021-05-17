package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PackageDeclaration extends PackageDeclarationTree {
    public PackageDeclaration(Identifier iAST, Declaration dAST, SourcePosition declarationPos){
        super(declarationPos);
        duplicated = false;
        I = iAST;
        D = dAST;
    }

    public Identifier I;
    public Declaration D;
    public boolean duplicated;

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitPackageDeclaration(this,o);
    }
}