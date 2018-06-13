package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import java.util.UUID;

public final class AbonnementId {

    private final UUID id;

    private AbonnementId(UUID id) {
        this.id = id;
    }

    public static AbonnementId generate() {
        return new AbonnementId(UUID.randomUUID());
    }

    public UUID id() {
        return id;
    }
}
