package fr.octo.craft.salle_de_sport.Formule.Domain;

import java.util.Objects;

public final class FormuleId {

    private final String id;

    private FormuleId(String id) {
        this.id = id;
    }

    public static FormuleId fromString(String id) {
        return new FormuleId(id);
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
        FormuleId formuleId = (FormuleId) o;
        return Objects.equals(id, formuleId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
