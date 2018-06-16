package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;

import java.text.ParseException;

public final class AbonnementSouscrit {

    private final String adhérentId;
    private final String formuleId;
    private final String abonnementId;
    private final String dateDeSouscription;

    public AbonnementSouscrit(Adhérent adhérent, Formule formule, Abonnement abonnement) {
        this.adhérentId = adhérent.id().toString();
        this.formuleId = formule.id().toString();
        this.abonnementId = abonnement.id().toString();
        this.dateDeSouscription = abonnement.dateDeSouscription().toString();
    }

    public AdhérentId adhérentId() {
        return AdhérentId.fromString(adhérentId);
    }

    public FormuleId formuleId() {
        return FormuleId.fromString(formuleId);
    }

    public AbonnementId abonnementId() {
        return AbonnementId.fromString(abonnementId);
    }

    public MaDate dateDeSouscription() throws ParseException {
        return MaDate.fromString(dateDeSouscription);
    }
}
