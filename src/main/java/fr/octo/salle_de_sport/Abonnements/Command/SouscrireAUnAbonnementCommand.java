package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.MaDate;
import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéId;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;

final class SouscrireAUnAbonnementCommand {

    private final String abonnéId;
    private final String formuleId;
    private final String date;

    SouscrireAUnAbonnementCommand(Abonné abonné, Formule formule, MaDate date) {
        this.abonnéId = abonné.id().toString();
        this.formuleId = formule.id().toString();
        this.date = date.toString();
    }

    AbonnéId abonnéId() {
        return AbonnéId.fromString(abonnéId);
    }

    FormuleId formuleId() {
        return FormuleId.fromString(formuleId);
    }

    public MaDate date() {
        return MaDate.fromString(date);
    }
}
