package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import fr.octo.craft.SalleDeSport.Adherent.Domain.AdhérentId;

public final class AbonnementSouscrit {

    public final AdhérentId adhérentId;
    public final AbonnementId abonnementId;

    public AbonnementSouscrit(AdhérentId adhérentId, AbonnementId abonnementId) {
        this.adhérentId = adhérentId;
        this.abonnementId = abonnementId;
    }
}
