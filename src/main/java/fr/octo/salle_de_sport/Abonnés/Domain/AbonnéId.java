package fr.octo.salle_de_sport.Abonnés.Domain;

import fr.octo.craft.ddd.AggregateId;

public final class AbonnéId extends AggregateId {

    public AbonnéId() {
        super();
    }

    public AbonnéId(String id) {
        super(id);
    }
}
