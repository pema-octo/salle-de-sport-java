package fr.octo.craft.SalleDeSport.Abonnement.Command;

import fr.octo.craft.SalleDeSport.Abonnement.Domain.MaDate;
import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;

import java.text.ParseException;

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

    public MaDate date() throws ParseException {
        return MaDate.fromString(date);
    }
}
