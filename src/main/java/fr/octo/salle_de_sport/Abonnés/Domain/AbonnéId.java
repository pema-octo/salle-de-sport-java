package fr.octo.salle_de_sport.Abonnés.Domain;

import fr.octo.salle_de_sport.AggregateId;

public final class AbonnéId extends AggregateId {

    public AbonnéId() {
        super();
    }

    public AbonnéId(String id) {
        super(id);
    }
}
