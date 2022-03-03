public class Useful 
{
    // Thank to https://stackoverflow.com/questions/4519557/is-there-a-way-to-throw-an-exception-without-adding-the-throws-declaration/4519576
    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void crash(Throwable exception, Object dummy) throws T
    {
        throw (T) exception;
    }

    public static void crash(String msg)
    {
        Useful.<RuntimeException>crash(new Exception(msg), null);
    }
}