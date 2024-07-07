package ExceptionHandling;

public class Main2
{
    public static void no_order()
    {
        //Error will occur since order not maintained
       /* try{
            int a[]=new int[5];
            a[5]=30/0;
        }
        catch(Exception e){System.out.println("common task completed");}
        catch(ArithmeticException e){System.out.println("task1 is completed");}
        catch(ArrayIndexOutOfBoundsException e){System.out.println("task 2 completed");}
        System.out.println("rest of the code...");
    }*/
}
    public static void main(String[] args)
    {
        no_order();
        try
        {
            int a[]=new int[5];
            a[5]=30/0;
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception occurs");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array Index out of bounds exception occurs");
        }
        catch(Exception e )
        {
            System.out.println("Parent exception occurs");
        }
        finally {
            System.out.println("Implemented finally block");
        }
        /* finally block in Java can be used to put "cleanup" code such as closing a file, closing connection, etc.
        The important statements to be printed can
         be placed in the finally block.*/
        System.out.println("Implementing rest of code");
    }
}
