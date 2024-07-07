package ExceptionHandling;

public class TestCustomException
{
    // method to check the age
    static void validate (int age) throws Main7{
        if(age < 18){

            // throw an object of user defined exception
            throw new Main7("age is not valid to vote");
        }
        else {
            System.out.println("welcome to vote");
        }
    }

    // main method
    public static void main(String args[])
    {
        try
        {
            // calling the method
            validate(13);
        }
        catch (Main7 ex)
        {
            System.out.println("Caught the exception");

            // printing the message from InvalidAgeException object
            System.out.println("Exception occured: " + ex);
        }

        System.out.println("rest of the code...");
    }
}
