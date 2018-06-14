package fr.octo.craft.SalleDeSport.Formule.Domain;

import java.util.Objects;
import java.util.UUID;

public final class FormuleId {

    private final UUID id;

    private FormuleId(UUID id) {
        this.id = id;
    }

    public static FormuleId generate() {
        return new FormuleId(UUID.randomUUID());
    }

    public UUID id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormuleId formuleId = (FormuleId) o;
        return Objects.equals(id, formuleId.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
