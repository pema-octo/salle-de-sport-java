package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.MaDate;
import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéId;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;

final class SouscrireAUnAbonnementCommand {

    final AbonnéId abonnéId;
    final FormuleId formuleId;
    final MaDate dateDeDébut;

    SouscrireAUnAbonnementCommand(Abonné abonné, Formule formule, MaDate dateDeDébut) {
        this.abonnéId = abonné.id();
        this.formuleId = formule.id();
        this.dateDeDébut = dateDeDébut;
    }
}
