import data.Athletes;
import data.Gender;
import data.Rules;
import service.SkiService;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public static void main(String[] args) {
    Rules.setMinimumAge(18);

    Athletes a1 = new Athletes("Alidzhan", "Bulgaria", Gender.MALE, LocalDate.of(2005,11,1), Duration.ofSeconds(15));
    Athletes a2 = new Athletes("Ivan",     "Ivanov",   Gender.MALE, LocalDate.of(2022,7,31), Duration.ofSeconds(23));
    Athletes a3 = new Athletes("Georgi",   "Ivanov",   Gender.MALE, LocalDate.of(2005,7,31), Duration.ofSeconds(17));
    Athletes a4 = new Athletes("Petur",    "Ivanov",   Gender.MALE, LocalDate.of(2005,7,31), Duration.ofSeconds(22));

    List<Athletes> athletesList = new ArrayList<>(Arrays.asList(a1, a2, a3, a4));

    SkiService service = new SkiService();

    List<Athletes> qualifiedForMansh2 = service.firstMansh(athletesList);
    System.out.println("Qualified for Mansh 2: " + qualifiedForMansh2);

    Scanner scanner = new Scanner(System.in);

    for (Athletes athlete : qualifiedForMansh2) {
        System.out.println("Enter second run time (seconds) for " + athlete.getName() + ": ");
        long seconds = scanner.nextLong();
        athlete.setSeconds(Duration.ofSeconds(seconds));
    }

    List<Athletes> finalRanking = service.secondMansh(qualifiedForMansh2);
    System.out.println("Final Ranking: " + finalRanking);
    System.out.println("Winner: " + service.winnerOfTheRace(finalRanking));
}