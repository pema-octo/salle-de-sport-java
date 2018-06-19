package fr.octo.salle_de_sport.Adherent.Domain;

import fr.octo.salle_de_sport.Abonnement.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnement.Domain.AbonnementId;

public final class EmailDeBienvenueALaSouscriptionEnvoyé {

    private final String email;
    private final String abonnementId;

    public EmailDeBienvenueALaSouscriptionEnvoyé(String email, Abonnement abonnement) {
        this.email = email;
        this.abonnementId = abonnement.id().toString();
    }

    public String email() {
        return email;
    }

    public AbonnementId abonnementId() {
        return AbonnementId.fromString(abonnementId);
    }
}
