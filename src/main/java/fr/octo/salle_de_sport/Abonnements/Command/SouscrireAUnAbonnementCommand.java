package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.MaDate;
import fr.octo.salle_de_sport.Adherents.Domain.Adhérent;
import fr.octo.salle_de_sport.Adherents.Domain.AdhérentId;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;

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
