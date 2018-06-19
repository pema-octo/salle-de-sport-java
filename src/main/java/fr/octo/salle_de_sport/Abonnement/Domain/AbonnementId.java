package fr.octo.salle_de_sport.Abonnement.Domain;

import java.util.Objects;

public final class AbonnementId {

    private final String id;

    private AbonnementId(String id) {
        this.id = id;
    }

    public static AbonnementId fromString(String id) {
        return new AbonnementId(id);
    }

    public String id() {
        return id;
    }

    @Override
    public String toString() {
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
