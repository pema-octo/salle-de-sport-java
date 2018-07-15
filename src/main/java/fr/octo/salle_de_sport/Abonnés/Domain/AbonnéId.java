package fr.octo.salle_de_sport.Abonnés.Domain;

import java.util.Objects;

public final class AbonnéId {

    private final String id;

    private AbonnéId(String id) {
        this.id = id;
    }

    public static AbonnéId fromString(String id) {
        return new AbonnéId(id);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbonnéId that = (AbonnéId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
