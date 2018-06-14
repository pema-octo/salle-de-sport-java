package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbonnementId that = (AbonnementId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
