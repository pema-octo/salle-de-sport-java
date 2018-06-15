package fr.octo.craft.SalleDeSport.Formule.Command;

import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleCréée;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleId;
import fr.octo.craft.SalleDeSport.Formule.Domain.FormuleRepository;

import java.util.UUID;

final class CréerUneNouvelleFormuleCommandHandler {

    private final FormuleRepository formuleRepository;

    CréerUneNouvelleFormuleCommandHandler(FormuleRepository formuleRepository) {
        this.formuleRepository = formuleRepository;
    }

    FormuleCréée handle(CréerUneNouvelleFormuleCommand command) {
        Formule formule = new Formule(
            FormuleId.fromString(UUID.randomUUID().toString()),
            command.prixDeBase,
            command.duréeFormule
        );

        formuleRepository.store(formule);

        return new FormuleCréée(
            formule.id()
        );
    }
}
