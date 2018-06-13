package fr.octo.craft.SalleDeSport.Formule.Domain;

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
}
