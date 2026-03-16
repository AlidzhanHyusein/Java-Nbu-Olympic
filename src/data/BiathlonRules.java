package data;

import java.time.Duration;

public class BiathlonRules {

    private static Duration minutesToQualify;
    private static int maxMisses;
    private static int maxShotsPerAthlete;
    private static int shootingLap;
    private static int laps;

    public static int getShootingLap() {
        return shootingLap;
    }

    public static void setShootingLap(int shootingLap) {
        BiathlonRules.shootingLap = shootingLap;
    }

    public static int getLaps() {
        return laps;
    }

    public static void setLaps(int laps) {
        BiathlonRules.laps = laps;
    }

    public static Duration getMinutesToQualify() {
        return minutesToQualify;
    }

    public static void setMinutesToQualify(Duration minutesToQualify) {
        BiathlonRules.minutesToQualify = minutesToQualify;
    }


    public static int getMaxMisses() {
        return maxMisses;
    }

    public static int getMaxShotsPerAthlete() {
        return maxShotsPerAthlete;
    }

    public static void setMaxShotsPerAthlete(int maxShotsPerAthlete) {
        BiathlonRules.maxShotsPerAthlete = maxShotsPerAthlete;
    }

    public static void setMaxMisses(int maxMisses) {
        BiathlonRules.maxMisses = maxMisses;
    }


}
