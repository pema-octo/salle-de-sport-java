package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.MaDate;

final class RenouvellerLesAbonnementsAutomatiquementCommand {
    final MaDate àPartirDe;

    RenouvellerLesAbonnementsAutomatiquementCommand(MaDate àPartirDe) {
        this.àPartirDe = àPartirDe;
    }
}
