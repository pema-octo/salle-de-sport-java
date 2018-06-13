package fr.octo.craft.SalleDeSport.Formule.Command;

import fr.octo.craft.SalleDeSport.Formule.Domain.*;

final class ChangerLePrixDUneFormuleCommandHandler {

    private final FormuleRepository formuleRepository;

    ChangerLePrixDUneFormuleCommandHandler(FormuleRepository formuleRepository) {
        this.formuleRepository = formuleRepository;
    }

    PrixFormuleChangé handle(ChangerLePrixDUneFormuleCommand command) throws FormuleRepositoryException {
        Formule formule = formuleRepository.get(command.formuleId);

        Prix ancienPrix = formule.prixDeBase();

        formule.changeDePrix(command.nouveauPrix);

        formuleRepository.store(formule);

        return new PrixFormuleChangé(
            formule.id(),
            ancienPrix,
            formule.prixDeBase()
        );
    }
}
