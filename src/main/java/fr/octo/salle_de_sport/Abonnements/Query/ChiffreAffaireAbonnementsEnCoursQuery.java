package fr.octo.salle_de_sport.Abonnements.Query;

import fr.octo.salle_de_sport.Abonnements.Domain.MaDate;

final class ChiffreAffaireAbonnementsEnCoursQuery {

    private final String àPartirDe;

    ChiffreAffaireAbonnementsEnCoursQuery(MaDate àPartirDe) {
        this.àPartirDe = àPartirDe.toString();
    }

    MaDate àPartirDe() {
        return MaDate.fromString(àPartirDe);
    }
}
