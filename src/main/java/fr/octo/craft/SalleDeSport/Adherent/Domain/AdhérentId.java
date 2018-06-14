package fr.octo.craft.SalleDeSport.Adherent.Domain;

import java.util.Objects;
import java.util.UUID;

public final class AdhérentId {

    private final UUID id;

    private AdhérentId(UUID id) {
        this.id = id;
    }

    public static AdhérentId generate() {
        return new AdhérentId(UUID.randomUUID());
    }

    public UUID id() {
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
