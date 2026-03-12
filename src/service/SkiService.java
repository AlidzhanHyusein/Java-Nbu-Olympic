package service;

import data.Athletes;
import data.Rules;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SkiService {

    public List<Athletes> firstMansh(List<Athletes> athletesList) {
        if (athletesList.isEmpty()) return List.of();

        return ageOfAthletes(athletesList).stream()
                .sorted(Comparator.comparing(Athletes::getSeconds))
                .limit(30)
                .peek(a -> a.setTotalSeconds(a.getSeconds()))
                .collect(Collectors.toList());
    }

    public List<Athletes> secondMansh(List<Athletes> qualifiedAthletes) {
        qualifiedAthletes.forEach(a ->
                a.setTotalSeconds(a.getTotalSeconds().plus(a.getSeconds()))
        );

        return qualifiedAthletes.stream()
                .sorted(Comparator.comparing(Athletes::getTotalSeconds))
                .collect(Collectors.toList());
    }

    public List<Athletes> winnerOfTheRace(List<Athletes> athletes) {
        Duration minTime = athletes.stream()
                .map(Athletes::getTotalSeconds)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("Athlete list is empty"));

        return athletes.stream()
                .filter(athlete -> athlete.getTotalSeconds().equals(minTime))
                .collect(Collectors.toList());
    }

    public List<Athletes> ageOfAthletes(List<Athletes> athletes) {
        return athletes.stream()
                .filter(a -> Period.between(a.getDateOfBirth(), LocalDate.now()).getYears() >= Rules.getMinimumAge())
                .collect(Collectors.toList());
    }
}