package ExceptionHandling;
import java.io.*;
public class Main6
{
    public void msg() throws Exception
    {
        System.out.println("parent method");
    }
}

class TestExceptionChild extends Main6
{
    public void msg()
    {
        System.out.println("child method");
    }

    public static void main(String args[]){
        TestExceptionChild  p = new TestExceptionChild();

        try {
            p.msg();
        }
        catch(Exception e) {}

    }
}
