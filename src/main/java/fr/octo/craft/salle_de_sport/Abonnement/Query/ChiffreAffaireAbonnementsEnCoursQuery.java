package fr.octo.craft.salle_de_sport.Abonnement.Query;

import fr.octo.craft.salle_de_sport.Abonnement.Domain.MaDate;

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
