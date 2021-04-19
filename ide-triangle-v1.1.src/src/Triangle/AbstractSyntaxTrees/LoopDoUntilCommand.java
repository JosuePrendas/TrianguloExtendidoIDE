package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class LoopDoUntilCommand extends Command {

    public LoopDoUntilCommand (Command c1AST, Expression eAST, SourcePosition thePosition) {

        super (thePosition);
        E = eAST;
        C1 = c1AST;

    }

    public Object visit(Visitor v, Object o) {
        return v.visitLoopDoUntilCommand(this, o);
    }

    public Expression E;
    public Command C1;

}