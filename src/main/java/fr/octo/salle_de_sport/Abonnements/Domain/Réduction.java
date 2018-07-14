package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Adherents.Domain.Adhérent;
import fr.octo.salle_de_sport.Formules.Domain.Formule;

public final class Réduction {

    static final Double REDUC_ETUDIANT = 0.2;
    static final Double REDUC_ANNEE = 0.3;

    private final Double taux;

    private Réduction(Double taux) {
        this.taux = taux;
    }

    Réduction(Adhérent adhérent, Formule formule) {
        Double tauxCalculé = 0.0;

        if (adhérent.estEtudiant()) {
            tauxCalculé += REDUC_ETUDIANT;
        }

        if (formule.estALannée()) {
            tauxCalculé += REDUC_ANNEE;
        }

        this.taux = tauxCalculé;
    }

    public static Réduction auTaux(Double taux) {
        return new Réduction(taux);
    }

    public Double taux() {
        return taux;
    }
}
