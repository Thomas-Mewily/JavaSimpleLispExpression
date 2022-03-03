
public class Parser
{
    public String Code;
    public int Index;

    public boolean IndexValid(){ return Index >= 0 && Index < Code.length(); }
    public char ReadChar()     { return IndexValid() ? Code.charAt(Index) : '\0'; }
    public char ReadCharAndMove() 
    {
        char c = ReadChar();
        Index++;
        return c;
    }
    public void ConsumeAndMove(char expected)
    {
        char c = ReadCharAndMove();
        if(expected != c){ Useful.crash("Expected char: '"+expected+"' instead of '"+c+"'");}
    }
    public Exp ErrorUnexpectedChar(char c)
    {
        Useful.crash("Unexpected char: '"+c+"'");
        return null;
    }

    public Parser(){}

    public Exp ParseExp(String code)
    {
        // Initialisation before recursivity
        Code = code;
        Index = 0;
        return Parse();
    }

    // recursivity è_é
    private Exp Parse()
    {
        char c = ReadCharAndMove();
        switch(c)
        {
            case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
            {
                double val = c-'0';
                while(IndexValid() && "0123456789".indexOf(ReadChar()) != -1)
                {
                    val = val*10+ ReadCharAndMove()-'0';
                }
                return new NumberExp(val);
            }
            case '(':
            {
                c = ReadCharAndMove();
                switch(c)
                {
                    case '+':case '-':case '*':case '/': break; // valid operation
                    default: return ErrorUnexpectedChar(c);
                }
                String op = c+""; //convert char to string
                Exp left  = Parse();
                Exp right = Parse();
                ConsumeAndMove(')');
                return new BinExp(op, left, right);
            }
            case ' ': case '\t': case '\n': case '\r': return Parse(); // Ignore space and other char
            default: return ErrorUnexpectedChar(c); // Crash
        }
    }
}