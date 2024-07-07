package ExceptionHandling;

public class Main1
{
    public static void main(String[] args) {
        try
        {
            int data=100/0;
        }catch(ArithmeticException e)
        {
            System.out.println(e);
            System.out.println("Successfully caught arithmetic error");
        }

        try{
            String s=null;
            System.out.println(s.length());
        }catch(NullPointerException e)
        {
            System.out.println(e);
            System.out.println("Successfully caught null pointer error");
        }

        try{
            String s="abc";
            int i=Integer.parseInt(s);
        }catch(NumberFormatException e)
        {
            System.out.println(e);
            System.out.println("Successfully caught format error");
        }

        try{
            int a[]=new int[5];
            a[10]=50;
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
            System.out.println("Successfully caught index out of bounds error");
        }
        finally {
            System.out.println("Implemented finally block");
        }

    }
}
