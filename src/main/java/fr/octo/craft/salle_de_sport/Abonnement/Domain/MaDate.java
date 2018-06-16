package fr.octo.craft.salle_de_sport.Abonnement.Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class MaDate {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private final Date date;

    public MaDate() {
        this.date = new Date();
    }

    MaDate(Date date) {
        this.date = date;
    }

    public static MaDate fromString(String dateStr) throws ParseException {
        return new MaDate(
            format.parse(dateStr)
        );
    }

    public String toString() {
        return format.format(date);
    }

    Date toDate() {
        return date;
    }
}
