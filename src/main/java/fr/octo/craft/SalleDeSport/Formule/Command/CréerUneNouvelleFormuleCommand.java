package fr.octo.craft.SalleDeSport.Formule.Command;

import fr.octo.craft.SalleDeSport.Formule.Domain.DuréeFormule;

final class CréerUneNouvelleFormuleCommand {

    final Double prixDeBase;
    final DuréeFormule duréeFormule;

    CréerUneNouvelleFormuleCommand(Double prixDeBase, DuréeFormule duréeFormule) {
        this.prixDeBase = prixDeBase;
        this.duréeFormule = duréeFormule;
    }
}
