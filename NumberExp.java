
public class NumberExp extends Exp
{
    public double Value;
    public NumberExp(double value){ Value = value;}

    public @Override String toString() {return Double.toString(Value); }
    public double Eval(){ return Value;}
}