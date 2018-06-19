package fr.octo.salle_de_sport.Formule.Infrastructure.Database;

import fr.octo.salle_de_sport.Formule.Domain.Formule;
import fr.octo.salle_de_sport.Formule.Domain.FormuleId;
import fr.octo.salle_de_sport.Formule.Domain.FormuleRepository;
import fr.octo.salle_de_sport.Formule.Domain.FormuleRepositoryException;

import java.util.ArrayList;
import java.util.Collection;

public final class FormuleInMemoryRepository implements FormuleRepository {

    private final Collection<Formule> formules = new ArrayList<>();

    @Override
    public void store(Formule formule) {
        formules.add(formule);
    }

    @Override
    public Formule get(FormuleId formuleId) throws FormuleRepositoryException {
        for (Formule formule : formules) {
            if (formule.id().equals(formuleId)) {
                return formule;
            }
        }

        throw FormuleRepositoryException.introuvable(formuleId);
    }
}
