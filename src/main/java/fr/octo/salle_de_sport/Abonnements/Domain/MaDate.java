package fr.octo.salle_de_sport.Abonnements.Domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public final class MaDate {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    private final LocalDate date;

    public MaDate() {
        this.date = LocalDate.now();
    }

    private MaDate(LocalDate date) {
        this.date = date;
    }

    public static MaDate fromString(String dateStr) {
        return new MaDate(
            LocalDate.parse(dateStr, FORMATTER)
        );
    }

    @Override
    public String toString() {
        return date.format(FORMATTER);
    }

    Boolean après(MaDate dateDeDébut) {
        return date.isAfter(dateDeDébut.date);
    }

    Boolean avant(MaDate dateDeFin) {
        return date.isBefore(dateDeFin.date);
    }

    MaDate plusXMois(Integer nbMois) {
        return new MaDate(
            date.plus(nbMois, ChronoUnit.MONTHS)
        );
    }

    MaDate jourDAvant() {
        return new MaDate(date.minusDays(1));
    }

    MaDate jourSuivant() {
        return new MaDate(date.plusDays(1));
    }

    LocalDate toLocalDate() {
        return date;
    }
}
