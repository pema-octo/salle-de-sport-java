package fr.octo.salle_de_sport.Abonnements.Query;

import fr.octo.salle_de_sport.Abonnements.Domain.MaDate;

final class ChiffreAffaireAbonnementsEnCoursQuery {

    private final String date;

    ChiffreAffaireAbonnementsEnCoursQuery(MaDate date) {
        this.date = date.toString();
    }

    public MaDate date() {
        return MaDate.fromString(date);
    }
}
