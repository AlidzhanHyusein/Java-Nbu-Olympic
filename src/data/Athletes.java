package data;

import java.time.Duration;
import java.time.LocalDate;

public class Athletes {

    private Long id;
    private String name;
    private String country;
    private Gender gender;
    private final LocalDate dateOfBirth;
    private static Long counterOfId = 0L;
    private Duration seconds;
    private Duration totalSeconds = Duration.ZERO;

    public Athletes(String name, String country, Gender gender, LocalDate localDate, Duration seconds) {
        this.id = ++counterOfId;
        this.name = name;
        this.country = country;
        this.gender = gender;
        this.dateOfBirth = localDate;
        this.seconds = seconds;
    }

    public Duration getTotalSeconds() {
        return totalSeconds;
    }

    public void setTotalSeconds(Duration totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    public Athletes(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
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

    public Gender getGander() {
        return gender;
    }

    public void setGander(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getCounterOfId() {
        return counterOfId;
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
                ", gander=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", seconds=" + seconds +
                ", totalSeconds=" + totalSeconds +
                '}';
    }
}
