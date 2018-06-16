package fr.octo.craft.SalleDeSport.Abonnement.Command;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

final class SouscrireAUnAbonnementCommand {

    private final String adhérentId;
    private final String formuleId;
    private final String date;

    SouscrireAUnAbonnementCommand(Adhérent adhérentId, Formule formuleId, Date date) {
        this.adhérentId = adhérentId.id().toString();
        this.formuleId = formuleId.id().toString();
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    AdhérentId adhérentId() {
        return AdhérentId.fromString(adhérentId);
    }

    FormuleId formuleId() {
        return FormuleId.fromString(formuleId);
    }

    public Date date() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
