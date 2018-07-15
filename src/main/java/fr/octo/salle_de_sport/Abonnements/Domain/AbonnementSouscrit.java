package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéId;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;

public final class AbonnementSouscrit {

    private final String abonnéId;
    private final String formuleId;
    private final String abonnementId;

    public AbonnementSouscrit(Abonné abonné, Formule formule, Abonnement abonnement) {
        this.abonnéId = abonné.id().toString();
        this.formuleId = formule.id().toString();
        this.abonnementId = abonnement.id().toString();
    }

    public AbonnéId abonnéId() {
        return AbonnéId.fromString(abonnéId);
    }

    public FormuleId formuleId() {
        return FormuleId.fromString(formuleId);
    }

    public AbonnementId abonnementId() {
        return AbonnementId.fromString(abonnementId);
    }
}
