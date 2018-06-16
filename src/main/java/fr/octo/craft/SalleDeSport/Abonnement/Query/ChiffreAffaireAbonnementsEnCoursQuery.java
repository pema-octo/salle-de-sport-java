package fr.octo.craft.SalleDeSport.Abonnement.Query;

import fr.octo.craft.SalleDeSport.Abonnement.Domain.MaDate;

import java.text.ParseException;

final class ChiffreAffaireAbonnementsEnCoursQuery {

    private final String date;

    ChiffreAffaireAbonnementsEnCoursQuery(MaDate date) {
        this.date = date.toString();
    }

    public MaDate date() throws ParseException {
        return MaDate.fromString(date);
    }
}
