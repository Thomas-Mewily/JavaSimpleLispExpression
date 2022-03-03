
public class BinExp extends Exp // Binary expression
{
    public String Operation;
    public Exp Left, Right;

    public BinExp(String operation, Exp left, Exp right)
    { 
        Operation = operation;
        Left = left;
        Right = right;
    }

    public @Override String toString() {return "(" + Operation + " " + Left + " " + Right+" )"; }
    public double Eval()
    { 
        switch(Operation)
        {
            case "+": return Left.Eval()+Right.Eval();
            case "-": return Left.Eval()-Right.Eval();
            case "*": return Left.Eval()*Right.Eval();
            case "/": return Left.Eval()/Right.Eval();
            default : Useful.crash("Unknow binary operator: "+Operation); return 0; // Error
        }
    }
}