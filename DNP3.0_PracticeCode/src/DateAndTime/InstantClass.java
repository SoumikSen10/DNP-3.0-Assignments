package DateAndTime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class InstantClass
{
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis); // from
        // January 1,1970 UTC


        Instant start=Instant.now();
        Instant end=Instant.now();

        //Finding duration or time diff
        Duration d1 = Duration.between(start,end);
        Duration d2 = Duration.of(1, ChronoUnit.MILLIS);
        System.out.println(d1);
        System.out.println(d2);

        //for larger time diff which includes a year or month or some weeks we use period and not duration

        LocalDate now = LocalDate.now();
        LocalDate then = LocalDate.of(1990,2,2);

        Period period = Period.between(now,then);
        System.out.println(period);

    }
}
