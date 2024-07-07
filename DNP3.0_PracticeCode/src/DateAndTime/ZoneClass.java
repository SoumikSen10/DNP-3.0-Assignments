package DateAndTime;

import java.time.ZonedDateTime;

public class ZoneClass
{
    public static void main(String[] args)
    {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        ZonedDateTime zdt = ZonedDateTime.parse("2023-04-23T10:30:00-04:00[America/New_York]");
        System.out.println(zdt);
    }
}
