package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéId;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;

public final class AbonnementSouscrit {

    public final AbonnéId abonnéId;
    public final FormuleId formuleId;
    public final AbonnementId abonnementId;

    public AbonnementSouscrit(Abonné abonné, Formule formule, Abonnement abonnement) {
        this.abonnéId = abonné.id();
        this.formuleId = formule.id();
        this.abonnementId = abonnement.id();
    }
}
