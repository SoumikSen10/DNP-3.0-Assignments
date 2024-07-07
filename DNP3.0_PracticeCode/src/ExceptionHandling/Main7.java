package ExceptionHandling;

public class Main7 extends Exception {
    public Main7(String str) {
        // calling the constructor of parent Exception
        super(str);
    }
}

/*
In order to create custom exception, we need
to extend Exception class that belongs to
java.lang package.

We need to write the constructor that
takes the String as the error message
and it is called parent class
constructor.
*/