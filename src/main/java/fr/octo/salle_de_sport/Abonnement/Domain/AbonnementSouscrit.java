package fr.octo.salle_de_sport.Abonnement.Domain;

import fr.octo.salle_de_sport.Adherent.Domain.Adhérent;
import fr.octo.salle_de_sport.Adherent.Domain.AdhérentId;
import fr.octo.salle_de_sport.Formule.Domain.Formule;
import fr.octo.salle_de_sport.Formule.Domain.FormuleId;

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

    public MaDate dateDeSouscription() {
        return MaDate.fromString(dateDeSouscription);
    }
}
