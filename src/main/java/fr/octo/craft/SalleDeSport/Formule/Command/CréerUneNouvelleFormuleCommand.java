package fr.octo.craft.SalleDeSport.Formule.Command;

import fr.octo.craft.SalleDeSport.Formule.Domain.DuréeFormule;

final class CréerUneNouvelleFormuleCommand {

    final double prixDeBase;
    final DuréeFormule duréeFormule;

    CréerUneNouvelleFormuleCommand(double prixDeBase, DuréeFormule duréeFormule) {
        this.prixDeBase = prixDeBase;
        this.duréeFormule = duréeFormule;
    }
}
