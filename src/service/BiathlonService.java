package service;

import data.BiathlonAthletes;
import data.BiathlonRules;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BiathlonService {


    public void settingTime(int minutes, int seconds) {
        BiathlonRules.setMinutesToQualify(Duration.ofMinutes(minutes).plusSeconds(seconds));
    }

    public void settingMaxMissesPerShots(int shots){
        BiathlonRules.setMaxMisses(shots);
    }


    public List<BiathlonAthletes> getQualifiedAthletes(List<BiathlonAthletes> biathlonAthletes) {
        return biathlonAthletes.stream()
                .filter(athlete -> athlete.getMissedShots() <= BiathlonRules.getMaxMisses())
                .filter(athlete -> athlete.getMinutes().compareTo(BiathlonRules.getMinutesToQualify()) <= 0)
                .collect(Collectors.toList());
    }

    public List<BiathlonAthletes> calculatingPenalties(List<BiathlonAthletes> athletes){

        Scanner scanner = new Scanner(System.in);

        athletes.forEach(athlete -> {
            System.out.println("Enter shots for: " + athlete.getName());
            for (int i = 1; i <= BiathlonRules.getMaxShotsPerAthlete(); i++) {
                if(athlete.getMissedShots() == BiathlonRules.getMaxMisses()){
                    System.out.println("You run out of tries");
                    break;
                }

                int shot;

                do {
                    System.out.println("Shot " + i + " (1 = hit, 0 = miss): ");
                    shot = scanner.nextInt();
                } while (shot != 0 && shot != 1);

                if (shot != 1) {
                    athlete.setMissedShots(athlete.getMissedShots() + 1);
                }
            }
        });

        return athletes;
    }

    public List<BiathlonAthletes> calculatingPenaltiesTime(List<BiathlonAthletes> biathlonAthletes){

        return biathlonAthletes.stream().peek(athletes -> athletes.setMinutes(athletes.getMinutes().plusMinutes(athletes.getMissedShots()))).collect(Collectors.toList());
    }

    public List<BiathlonAthletes> sortingAthletesByTime(List<BiathlonAthletes> biathlonAthletes) {
        return biathlonAthletes.stream()
                .sorted(Comparator.comparing(BiathlonAthletes::getMinutes))
                .collect(Collectors.toList());
    }

    public boolean isShootingLap(List<BiathlonAthletes> biathlonAthletes) {

        boolean hadShooting = false;

        for (int i = 1; i <= BiathlonRules.getLaps(); i++) {

            if (i == BiathlonRules.getShootingLap()) {
                calculatingPenaltiesTime(biathlonAthletes);
                hadShooting = true;
            }
            biathlonAthletes.forEach(b -> b.setLaps(b.getLaps() + 1));
        }
        return hadShooting;
    }
}
