package fr.octo.salle_de_sport.Formule.Command;

import fr.octo.salle_de_sport.Formule.Domain.DuréeFormule;

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
