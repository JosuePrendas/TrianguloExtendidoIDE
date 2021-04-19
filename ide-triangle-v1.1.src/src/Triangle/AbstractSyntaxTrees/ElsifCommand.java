package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ElsifCommand extends Command {

    public ElsifCommand (ElsifCommand eiAST, Expression eAST, Command c1AST, SourcePosition thePosition) {
        super (thePosition);
        E = eAST;
        C1 = c1AST;
        EI = eiAST;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitElsifCommand(this, o);
    }

    public Expression E;
    public Command C1;
    public ElsifCommand EI;
}