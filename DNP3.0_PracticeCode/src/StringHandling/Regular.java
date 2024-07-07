package StringHandling;

public class Regular
{
    public static void main(String[] args) {
        char ch[]={'j','a','v','a'};
        String s=new String(ch);
        System.out.println(s);
        //String s="java";   both are the same thing. Above and below

        String s1="Welcome";
        String s2="Welcome";//it doesn'y create a new instance
        // the literal "Welcome" will be placed in the string constant
        // pool.

        //another way to create is
        String s3=new String("Welcome");
        //In such case, JVM will create a new string object in normal
        // (non-pool) heap memory

        String txt = "Hello World";
        System.out.println(txt.toUpperCase());   // Outputs "HELLO WORLD"
        System.out.println(txt.toLowerCase());   // Outputs "hello world"

        String text = "Please locate where 'locate' occurs!";
        System.out.println(text.indexOf("locate")); // Outputs 7

    }

}

/*
* The CharSequence interface is used to represent the sequence of
* characters. String, StringBuffer and StringBuilder classes implement
* it. It means, we can create strings in Java by using these three
* classes.

How to create a string object?

There are two ways to create String object:
By string literal
By new keyword
*/