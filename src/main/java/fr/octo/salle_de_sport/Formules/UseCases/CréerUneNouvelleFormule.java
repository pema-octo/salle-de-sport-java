package fr.octo.salle_de_sport.Formules.UseCases;

import fr.octo.salle_de_sport.Formules.Domain.*;

final class CréerUneNouvelleFormule {

    private final FormuleRepository formuleRepository;

    CréerUneNouvelleFormule(FormuleRepository formuleRepository) {
        this.formuleRepository = formuleRepository;
    }

    FormuleCréée handle(final Prix prixDeBase, final DuréeFormule duréeFormule) {

        var formule = new Formule(
            prixDeBase,
            duréeFormule
        );

        formuleRepository.store(formule);

        return new FormuleCréée(formule.id());
    }
}
