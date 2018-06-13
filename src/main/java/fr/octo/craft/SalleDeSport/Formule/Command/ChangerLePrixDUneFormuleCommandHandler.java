package fr.octo.craft.SalleDeSport.Formule.Command;

import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleRepositoryException;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleRepository;
import fr.octo.craft.SalleDeSport.Formule.Domain.PrixFormuleChangé;

final class ChangerLePrixDUneFormuleCommandHandler {

    private final FormuleRepository formuleRepository;

    ChangerLePrixDUneFormuleCommandHandler(FormuleRepository formuleRepository) {
        this.formuleRepository = formuleRepository;
    }

    PrixFormuleChangé handle(ChangerLePrixDUneFormuleCommand command) throws FormuleRepositoryException {
        Formule formule = formuleRepository.get(command.formuleId);

        double ancienPrix = formule.prixDeBase();

        formule.changeDePrix(command.nouveauPrix);

        formuleRepository.store(formule);

        return new PrixFormuleChangé(
            formule.id(),
            ancienPrix,
            formule.prixDeBase()
        );
    }
}
