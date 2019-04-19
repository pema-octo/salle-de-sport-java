package fr.octo.salle_de_sport.Abonnés.Domain;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementId;

public final class EmailDeBienvenueALaSouscriptionEnvoyé {

    public final String email;
    public final AbonnementId abonnementId;

    public EmailDeBienvenueALaSouscriptionEnvoyé(final String email, final Abonnement abonnement) {
        this.email = email;
        this.abonnementId = abonnement.id();
    }
}
