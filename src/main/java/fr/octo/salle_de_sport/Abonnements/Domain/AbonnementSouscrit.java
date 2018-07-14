package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Adherents.Domain.Adhérent;
import fr.octo.salle_de_sport.Adherents.Domain.AdhérentId;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;

public final class AbonnementSouscrit {

    private final String adhérentId;
    private final String formuleId;
    private final String abonnementId;

    public AbonnementSouscrit(Adhérent adhérent, Formule formule, Abonnement abonnement) {
        this.adhérentId = adhérent.id().toString();
        this.formuleId = formule.id().toString();
        this.abonnementId = abonnement.id().toString();
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
}
