package fr.octo.salle_de_sport.Formules.UseCases;

import fr.octo.salle_de_sport.Formules.Domain.*;

final class ChangerLePrixDUneFormule {

    private final FormuleRepository formuleRepository;

    ChangerLePrixDUneFormule(FormuleRepository formuleRepository) {
        this.formuleRepository = formuleRepository;
    }

    PrixFormuleChangé handle(final FormuleId formuleId, final Prix nouveauPrix) throws FormuleRepositoryException {

        var formule = formuleRepository.get(formuleId);

        var ancienPrix = formule.prixDeBase();

        formule.changeDePrix(nouveauPrix);

        formuleRepository.store(formule);

        return new PrixFormuleChangé(
            formule.id(),
            ancienPrix,
            formule.prixDeBase()
        );
    }
}
