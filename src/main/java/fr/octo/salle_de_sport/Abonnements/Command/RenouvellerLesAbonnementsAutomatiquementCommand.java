package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.DateCustom;

final class RenouvellerLesAbonnementsAutomatiquementCommand {

    final DateCustom àPartirDe;

    RenouvellerLesAbonnementsAutomatiquementCommand(final DateCustom àPartirDe) {
        this.àPartirDe = àPartirDe;
    }
}
