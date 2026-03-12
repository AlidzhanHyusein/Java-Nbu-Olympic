package data;

import java.time.LocalDate;
import java.util.List;

public class Ski {

    private int mansh = 0;
    List<Athletes> athletes;
    private static boolean  isOver;

    public Ski(List<Athletes> athletes) {
        mansh++;
        this.athletes = athletes;

    }

    public static boolean isIsOver() {
        return isOver;
    }

    public static void setIsOver(boolean isOver) {
        Ski.isOver = isOver;
    }


    public int getMansh() {
        return mansh;
    }

    public void setMansh(int mansh) {
        this.mansh = mansh;
    }

    public List<Athletes> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Athletes> athletes) {
        this.athletes = athletes;
    }


    public void reset() {
        this.mansh = 0;
        isOver = false;
    }


    @Override
    public String toString() {
        return "Ski{" +
                "mansh=" + mansh +
                ", athletes=" + athletes +
                '}';
    }
}
