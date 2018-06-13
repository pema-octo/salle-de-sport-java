package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;

final class Réduction {

    static final double REDUC_ETUDIANT = 0.2;
    static final double REDUC_ANNEE = 0.3;

    private final double taux;

    private Réduction(double taux) {
        this.taux = taux;
    }

    static Réduction auTaux(double taux) {
        return new Réduction(taux);
    }

    static Réduction pourAbonnement(Adhérent adhérent, Formule formule) {
        double tauxCalculé = 0;

        if (adhérent.estEtudiant()) {
            tauxCalculé += REDUC_ETUDIANT;
        }

        if (formule.estALannée()) {
            tauxCalculé += REDUC_ANNEE;
        }

        return new Réduction(tauxCalculé);
    }

    double taux() {
        return taux;
    }
}
