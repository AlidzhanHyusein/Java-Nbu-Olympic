package data;

import java.time.Duration;
import java.util.List;

public class Rules {

    private static Integer minimumAge;

    private static Duration secondsToQualify;


    public static Integer getMinimumAge() {
        return minimumAge;
    }

    public static void setMinimumAge(Integer minimumAge) {
        Rules.minimumAge = minimumAge;
    }

    public static Duration getSecondsToQualify() {
        return secondsToQualify;
    }

    public static void setSecondsToQualify(Duration secondsToQualify) {
        Rules.secondsToQualify = secondsToQualify;
    }
}
