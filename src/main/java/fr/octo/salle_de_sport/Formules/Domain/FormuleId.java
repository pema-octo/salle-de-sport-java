package fr.octo.salle_de_sport.Formules.Domain;

import fr.octo.salle_de_sport.AggregateId;

public final class FormuleId extends AggregateId {

    public FormuleId() {
        super();
    }

    public FormuleId(String id) {
        super(id);
    }
}
