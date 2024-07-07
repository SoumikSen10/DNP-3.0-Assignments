package DateAndTime;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterClass
{
    public static void main(String[] args)
    {
       String date="08/07/2024";
       DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parse = LocalDate.parse(date,dateTimeFormatter);
        System.out.println(parse);


        String dateTimeString = "2023-04-24 10:30:45+05:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXX");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeString,formatter);
        System.out.println(zonedDateTime);

    }
}
