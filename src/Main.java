import data.*;
import service.BiathlonService;
import service.SkiService;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public static void main(String[] args) {
    SkiRules.setMinimumAge(18);
    SkiRules.setSecondsToQualify(Duration.ofSeconds(20));

    SkiAthletes a1 = new SkiAthletes("Alidzhan", "Bulgaria", Gender.MALE, LocalDate.of(2005, 11, 1), Duration.ofSeconds(15));
    SkiAthletes a2 = new SkiAthletes("Ivan", "Ivanov", Gender.MALE, LocalDate.of(2022, 7, 31), Duration.ofSeconds(23));
    SkiAthletes a3 = new SkiAthletes("Georgi", "Ivanov", Gender.MALE, LocalDate.of(2005, 7, 31), Duration.ofSeconds(17));
    SkiAthletes a4 = new SkiAthletes("Petur", "Ivanov", Gender.MALE, LocalDate.of(2005, 7, 31), Duration.ofSeconds(22));

    List<SkiAthletes> athletesList = new ArrayList<>(Arrays.asList(a1, a2, a3, a4));

    SkiService service = new SkiService();

    List<SkiAthletes> qualifiedForMansh2 = service.firstMansh(athletesList);
    System.out.println("Qualified for Mansh 2: " + qualifiedForMansh2);

    Scanner scanner = new Scanner(System.in);

    for (SkiAthletes athlete : qualifiedForMansh2) {
        System.out.println("Enter second run time (seconds) for " + athlete.getName() + ": ");
        long seconds = scanner.nextLong();
        athlete.setSeconds(Duration.ofSeconds(seconds));
    }

    List<SkiAthletes> finalRanking = service.secondMansh(qualifiedForMansh2);
    System.out.println("Final Ranking: " + finalRanking);
    System.out.println("Winner: " + service.winnerOfTheRace(finalRanking));

    BiathlonService biathlonService = new BiathlonService();

    System.out.println("Set minutes to qualify");
    int minutes = scanner.nextInt();

    System.out.println("Set seconds to qualify");
    int seconds = scanner.nextInt();

    biathlonService.settingTime(minutes, seconds);


    System.out.println("Set maximum shots per athlete");
    BiathlonRules.setMaxShotsPerAthlete(scanner.nextInt());

    System.out.println("Set maximum misses per shots");
    biathlonService.settingMaxMissesPerShots(scanner.nextInt());

    System.out.println("Set laps");
    BiathlonRules.setLaps(scanner.nextInt());

    System.out.println("Set lap of shooting");
    BiathlonRules.setShootingLap(scanner.nextInt());


    BiathlonAthletes b1 = new BiathlonAthletes("Alidzhan",  Duration.ofMinutes(3));
    BiathlonAthletes b2 = new BiathlonAthletes("Tedi", Duration.ofMinutes(2));
    BiathlonAthletes b3 = new BiathlonAthletes("Krasio",  Duration.ofMinutes(1));

    List<BiathlonAthletes> biathlonAthletes = new ArrayList<>(Arrays.asList(b1, b2, b3));

    biathlonService.calculatingPenalties(biathlonAthletes);
    biathlonService.isShootingLap(biathlonAthletes);

    List<BiathlonAthletes> qualified = biathlonService.getQualifiedAthletes(biathlonAthletes);
    System.out.println(biathlonService.sortingAthletesByTime(qualified));
}