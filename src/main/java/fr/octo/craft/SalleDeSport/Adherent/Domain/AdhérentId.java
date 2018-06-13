package fr.octo.craft.SalleDeSport.Adherent.Domain;

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
}
