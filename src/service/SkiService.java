package service;

import data.SkiAthletes;
import data.SkiRules;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SkiService {

    public List<SkiAthletes> firstMansh(List<SkiAthletes> athletesList) {
        if (athletesList.isEmpty()) return List.of();

        return ageOfAthletes(athletesList).stream()
                .filter(athletes -> athletes.getSeconds().compareTo(SkiRules.getSecondsToQualify()) <= 0)
                .sorted(Comparator.comparing(SkiAthletes::getSeconds))
                .limit(30)
                .peek(a -> a.setTotalSeconds(a.getSeconds()))
                .collect(Collectors.toList());
    }

    public List<SkiAthletes> secondMansh(List<SkiAthletes> qualifiedAthletes) {
        qualifiedAthletes.forEach(a ->
                a.setTotalSeconds(a.getTotalSeconds().plus(a.getSeconds()))
        );

        return qualifiedAthletes.stream()
                .sorted(Comparator.comparing(SkiAthletes::getTotalSeconds))
                .collect(Collectors.toList());
    }

    public List<SkiAthletes> winnerOfTheRace(List<SkiAthletes> athletes) {
        Duration minTime = athletes.stream()
                .map(SkiAthletes::getTotalSeconds)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("Athlete list is empty"));

        return athletes.stream()
                .filter(athlete -> athlete.getTotalSeconds().equals(minTime))
                .collect(Collectors.toList());
    }

    public List<SkiAthletes> ageOfAthletes(List<SkiAthletes> athletes) {
        return athletes.stream()
                .filter(a -> Period.between(a.getDateOfBirth(), LocalDate.now()).getYears() >= SkiRules.getMinimumAge())
                .collect(Collectors.toList());
    }
}