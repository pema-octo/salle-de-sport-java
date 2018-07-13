package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.MaDate;

final class RenouvellerLesAbonnementsAutomatiquementCommand {
    final MaDate date;

    RenouvellerLesAbonnementsAutomatiquementCommand(MaDate date) {
        this.date = date;
    }
}
