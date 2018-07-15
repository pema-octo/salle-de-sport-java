package fr.octo.salle_de_sport.Formules.Command;

import fr.octo.salle_de_sport.Formules.Domain.*;

final class ChangerLePrixDUneFormuleCommandHandler {

    private final FormuleRepository formuleRepository;

    ChangerLePrixDUneFormuleCommandHandler(FormuleRepository formuleRepository) {
        this.formuleRepository = formuleRepository;
    }

    PrixFormuleChangé handle(ChangerLePrixDUneFormuleCommand command) throws FormuleRepositoryException {

        Formule formule = formuleRepository.get(command.formuleId());

        Prix ancienPrix = formule.prixDeBase();

        formule.changeDePrix(command.nouveauPrix());

        formuleRepository.store(formule);

        return new PrixFormuleChangé(
            formule,
            ancienPrix,
            formule.prixDeBase()
        );
    }
}
