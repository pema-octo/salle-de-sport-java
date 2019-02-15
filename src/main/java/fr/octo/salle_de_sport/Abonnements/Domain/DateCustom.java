package fr.octo.salle_de_sport.Abonnements.Domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public final class DateCustom {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    private final LocalDate date;

    public DateCustom() {
        this.date = LocalDate.now();
    }

    private DateCustom(LocalDate date) {
        this.date = date;
    }

    public DateCustom(String dateStr) {
        this(LocalDate.parse(dateStr, FORMATTER));
    }

    @Override
    public String toString() {
        return date.format(FORMATTER);
    }

    Boolean après(final DateCustom dateDeDébut) {
        return date.isAfter(dateDeDébut.date);
    }

    Boolean aprèsOuÉgale(final DateCustom dateDeDébut) {
        return date.isEqual(dateDeDébut.date) || date.isAfter(dateDeDébut.date);
    }

    Boolean avant(final DateCustom dateDeFin) {
        return date.isBefore(dateDeFin.date);
    }

    DateCustom plusXMois(final Integer nbMois) {
        return new DateCustom(
            date.plus(nbMois, ChronoUnit.MONTHS)
        );
    }

    DateCustom jourDAvant() {
        return new DateCustom(date.minusDays(1));
    }

    DateCustom jourSuivant() {
        return new DateCustom(date.plusDays(1));
    }

    LocalDate toLocalDate() {
        return date;
    }
}
