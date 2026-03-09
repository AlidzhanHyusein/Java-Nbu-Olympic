import data.Athletes;
import data.Gander;

import java.time.Duration;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        Duration time = Duration.ofSeconds(10);
        Athletes athletes = new Athletes("Alidzhan","Bulgaria", Gander.MALE, LocalDate.of(2005,11,1), Duration.ofMillis(9580));
        Athletes athletes1 = new Athletes("Teodora","Bulgaroa",Gander.FEMALE,LocalDate.of(2005,7,31), Duration.ofMillis(10000));
        System.out.println(time);
        System.out.println(athletes);
        System.out.println(athletes1);
    }
}
