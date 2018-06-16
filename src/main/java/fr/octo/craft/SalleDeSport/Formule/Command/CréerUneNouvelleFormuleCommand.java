package fr.octo.craft.SalleDeSport.Formule.Command;

import fr.octo.craft.SalleDeSport.Formule.Domain.DuréeFormule;

final class CréerUneNouvelleFormuleCommand {

    private final String prixDeBase;
    private final String duréeFormule;

    CréerUneNouvelleFormuleCommand(String prixDeBase, String duréeFormule) {
        this.prixDeBase = prixDeBase;
        this.duréeFormule = duréeFormule;
    }

    Double prixDeBase() {
        return Double.valueOf(prixDeBase);
    }

    DuréeFormule duréeFormule() {
        return DuréeFormule.valueOf(duréeFormule);
    }
}
