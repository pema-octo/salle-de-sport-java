package fr.octo.salle_de_sport.Formule.Command;

import fr.octo.salle_de_sport.Formule.Domain.Formule;
import fr.octo.salle_de_sport.Formule.Domain.FormuleCréée;
import fr.octo.salle_de_sport.Formule.Domain.FormuleId;
import fr.octo.salle_de_sport.Formule.Domain.FormuleRepository;

import java.util.UUID;

final class CréerUneNouvelleFormuleCommandHandler {

    private final FormuleRepository formuleRepository;

    CréerUneNouvelleFormuleCommandHandler(FormuleRepository formuleRepository) {
        this.formuleRepository = formuleRepository;
    }

    public String handles() {
        return CréerUneNouvelleFormuleCommand.class.getCanonicalName();
    }

    FormuleCréée handle(CréerUneNouvelleFormuleCommand command) {

        Formule formule = new Formule(
            FormuleId.fromString(UUID.randomUUID().toString()),
            command.prixDeBase(),
            command.duréeFormule()
        );

        formuleRepository.store(formule);

        return new FormuleCréée(formule);
    }
}
