package data;

import java.time.Duration;

public class SkiRules {

    private static Integer minimumAge;

    private static Duration secondsToQualify;


    public static Integer getMinimumAge() {
        return minimumAge;
    }

    public static void setMinimumAge(Integer minimumAge) {
        SkiRules.minimumAge = minimumAge;
    }

    public static Duration getSecondsToQualify() {
        return secondsToQualify;
    }

    public static void setSecondsToQualify(Duration secondsToQualify) {
        SkiRules.secondsToQualify = secondsToQualify;
    }
}
