package fr.octo.craft.SalleDeSport.Formule.Command;

import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleCréée;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleRepository;

final class CréerUneNouvelleFormuleCommandHandler {

    private final FormuleRepository formuleRepository;

    CréerUneNouvelleFormuleCommandHandler(FormuleRepository formuleRepository) {
        this.formuleRepository = formuleRepository;
    }

    FormuleCréée handle(CréerUneNouvelleFormuleCommand command) {
        Formule formule = Formule.nouvelle(
            command.prixDeBase,
            command.duréeFormule
        );

        formuleRepository.store(formule);

        return new FormuleCréée(
            formule.id()
        );
    }
}
