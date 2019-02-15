package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.craft.ddd.AggregateId;

public final class AbonnementId extends AggregateId {

    public AbonnementId() {
        super();
    }

    public AbonnementId(String id) {
        super(id);
    }
}
