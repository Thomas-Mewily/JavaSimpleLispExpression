// Made by Thomas / Mewily - 03/03/2022
// GitHub : https://github.com/Thomas-Mewily
// Ytb: https://www.youtube.com/channel/UCMzM4J9w0OEAb077mfrfXog
// Licence : GNU General Public License

public class Main {

    public static void main(String[] args) {
        System.out.println("Valid Expression:\n");
        TestExp("2002");
        TestExp("(+ 17 9)");
        TestExp("(*   4      9)");
        TestExp("(+ 2 (* 3 4))");
        TestExp("(/ 1 2)");
        TestExp("(/ 1 0)"); // 1/0 => Infinity, but still a valid expression
        TestExp("(+ (+ 1 1) (+ 1 1))");

        System.out.println("\nInvalid Expression:\n");
        // Error :
        TestExp("(");
        TestExp("(+ 2)");
        TestExp("(% 9 2)");
        TestExp("-2");
    }

    public static void TestExp(String exp)
    {
        Parser p = new Parser();

        try
        {
            Exp e = p.ParseExp(exp);
            double result = e.Eval();
            //System.out.println(e);
            System.out.println(exp+" => "+result);
        }catch (Exception e)
        {
            
            System.out.println("error with expression: "+exp);
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}