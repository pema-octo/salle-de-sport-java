package fr.octo.craft.SalleDeSport.Abonnement.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

final class ChiffreAffaireAbonnementsEnCoursQuery {

    private final String date;

    ChiffreAffaireAbonnementsEnCoursQuery(Date date) {
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public Date date() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
