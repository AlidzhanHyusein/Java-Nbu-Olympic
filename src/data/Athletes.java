package data;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Athletes {

    private Long id;
    private String name;
    private String country;
    private Gander gander;
    private final LocalDate dateOfBirth;
    private static Long counterOfId = 0L;
    private static final int minimalAge = 0;
    private Duration seconds;
    private static Duration secondsToQualify;

    public Athletes(String name, String country, Gander gender, LocalDate localDate, Duration seconds) {
        this.id = ++counterOfId;
        this.name = name;
        this.country = country;
        this.gander = gender;
        this.dateOfBirth = localDate;
        this.seconds = seconds;
    }


    public Athletes(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public static Duration getSecondsToQualify() {
        return secondsToQualify;
    }

    public static void setSecondsToQualify(Duration secondsToQualify) {
        Athletes.secondsToQualify = secondsToQualify;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Gander getGander() {
        return gander;
    }

    public void setGander(Gander gander) {
        this.gander = gander;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getCounterOfId() {
        return counterOfId;
    }

    public void setCounterOfId(Long counterOfId) {
        this.counterOfId = counterOfId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public void setSeconds(Duration seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Athletes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", gander=" + gander +
                ", dateOfBirth=" + dateOfBirth +
                ", seconds=" + String.format("%.3f",seconds.toMillis() / 1000.0) + "S" +
                '}';
    }
}
