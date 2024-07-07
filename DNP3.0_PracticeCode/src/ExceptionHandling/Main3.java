package ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main3
{
    //throwing unchecked exception
    public static void validate(int age)
    {
        if(age<18)
        {
            //throw arithmetic exception if not
            // eligible for vote
            throw new ArithmeticException("Person is not eligible to vote");
        }
        else
        {
            System.out.println("Person is eligible to vote");
        }
    }

    //throwing checked exception
    public static void validate1() throws FileNotFoundException
    {
        FileReader file=new FileReader("C:\\Users\\DragonRage\\Desktop\\abc.txt"); //this file doesnot exist
        BufferedReader fileInput=new BufferedReader(file);

        throw new FileNotFoundException();
    }
    public static void main(String[] args)
    {
        //validate(13);
        try
        {
            validate1();
        }
        catch(FileNotFoundException e )
        {
            e.printStackTrace();
            System.out.println("Path not found");
        }
    }
}

/*
The Java throw keyword is used to throw an
exception explicitly.

We specify the exception object which is to be
thrown. The Exception has some message with it that
provides the error description. These exceptions
may be related to user inputs, server, etc.

We can throw either checked or unchecked exceptions
in Java by throw keyword. It is mainly used to
throw a custom exception.
**/