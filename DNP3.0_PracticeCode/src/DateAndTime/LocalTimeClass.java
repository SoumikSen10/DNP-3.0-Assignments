package DateAndTime;

import java.time.LocalTime;

public class LocalTimeClass
{
    public static void main(String[] args)
    {
        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalTime customTime = LocalTime.of(14,30,30);
        System.out.println(customTime);
        LocalTime parsedTime = LocalTime.parse("15:30:45");
        System.out.println(parsedTime);
        LocalTime beforeOneHour = now.minusHours(1);
        if(now.isAfter(beforeOneHour))
        {
            System.out.println("Result is correct");
        }
        else
        {
            System.out.println("Incorrect result");
        }
    }
}
