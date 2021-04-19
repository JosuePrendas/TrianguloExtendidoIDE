package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PackageDeclarationTree extends AST {
    public PackageDeclarationTree(PackageDeclarationTree pdt1, PackageDeclarationTree pdt2, SourcePosition sourcePosition){
        super(sourcePosition);
        PDT1 = pdt1;
        PDT2 = pdt2;
    }

    public PackageDeclarationTree PDT1,PDT2;

    public PackageDeclarationTree(SourcePosition declarationPos) {
        super(declarationPos);
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitPackageDeclarationTree(this,o);
    }
}