package fr.octo.craft.SalleDeSport.Adherent.Domain;

import java.util.Objects;

public final class AdhérentId {

    private final String id;

    private AdhérentId(String id) {
        this.id = id;
    }

    public static AdhérentId fromString(String id) {
        return new AdhérentId(id);
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
        AdhérentId that = (AdhérentId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
