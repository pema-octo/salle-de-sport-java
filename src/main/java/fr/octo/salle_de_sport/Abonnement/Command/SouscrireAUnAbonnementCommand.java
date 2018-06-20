package fr.octo.salle_de_sport.Abonnement.Command;

import fr.octo.salle_de_sport.Abonnement.Domain.MaDate;
import fr.octo.salle_de_sport.Adherent.Domain.Adhérent;
import fr.octo.salle_de_sport.Adherent.Domain.AdhérentId;
import fr.octo.salle_de_sport.Formule.Domain.Formule;
import fr.octo.salle_de_sport.Formule.Domain.FormuleId;

final class SouscrireAUnAbonnementCommand {

    private final String adhérentId;
    private final String formuleId;
    private final String date;

    SouscrireAUnAbonnementCommand(Adhérent adhérentId, Formule formuleId, MaDate date) {
        this.adhérentId = adhérentId.id().toString();
        this.formuleId = formuleId.id().toString();
        this.date = date.toString();
    }

    AdhérentId adhérentId() {
        return AdhérentId.fromString(adhérentId);
    }

    FormuleId formuleId() {
        return FormuleId.fromString(formuleId);
    }

    public MaDate date() {
        return MaDate.fromString(date);
    }
}
