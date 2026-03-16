package data;

import java.time.Duration;

public class BiathlonAthletes {
    private int id;
    private String name;
    private int laps;
    private int missedShots;
    private Duration minutes;
    private static int counterOfId = 0;


    public BiathlonAthletes(String name, Duration minutes) {
        this.id = ++counterOfId;
        this.name = name;
        this.laps = 0;
        this.minutes = minutes;
    }

    public Duration getMinutes() {
        return minutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinutes(Duration minutes) {
        this.minutes = minutes;
    }

    public static int getCounterOfId() {
        return counterOfId;
    }

    public static void setCounterOfId(int counterOfId) {
        BiathlonAthletes.counterOfId = counterOfId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public int getMissedShots() {
        return missedShots;
    }

    public void setMissedShots(int missedShots) {
        this.missedShots = missedShots;
    }



    @Override
    public String toString() {
        return "Athlete: " + name +
                " | Time: " + String.format("%d:%02d", minutes.toMinutes(), minutes.toSecondsPart()) +
                " | Missed shots: " + missedShots +
                " | Laps: " + laps;
    }
}
