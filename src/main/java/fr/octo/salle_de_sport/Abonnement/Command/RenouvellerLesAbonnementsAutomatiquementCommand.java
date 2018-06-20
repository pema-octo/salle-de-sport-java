package fr.octo.salle_de_sport.Abonnement.Command;

import fr.octo.salle_de_sport.Abonnement.Domain.MaDate;

final class RenouvellerLesAbonnementsAutomatiquementCommand {
    final MaDate date;

    RenouvellerLesAbonnementsAutomatiquementCommand(MaDate date) {
        this.date = date;
    }
}
