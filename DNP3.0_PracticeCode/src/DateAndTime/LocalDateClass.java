package DateAndTime;

import java.time.LocalDate;

public class LocalDateClass
{
    public static void main(String[] args)
    {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate customDate = LocalDate.of(1990,2,7);

        //Based on current date
         int dayOfMonth=today.getDayOfMonth();
         int month = today.getMonthValue();
         int year = today.getYear();
        System.out.println(dayOfMonth);
        System.out.println(month);
        System.out.println(year);

        LocalDate yesterday=today.minusDays(1);
        System.out.println(yesterday);
        LocalDate pastDate = today.minusMonths(100); //after removing 100 months
        System.out.println(pastDate);
        if(today.isAfter(yesterday))
        {
            System.out.println("Results are correct");
        }
        else
        {
            System.out.println("Incorrect results");
        }
    }
}

/*
Need to know these 8 classes
1) Local Date
2) Local Time
3) Local LocalDateClass
4) Zoned LocalDateClass
5) Instant
6) Period
7) Duration
8) DateTimeFormatter
*/