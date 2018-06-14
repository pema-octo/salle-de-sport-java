package fr.octo.craft.SalleDeSport.Abonnement.Domain;

import fr.octo.craft.SalleDeSport.Adherent.Domain.Adhérent;
import fr.octo.craft.SalleDeSport.Formule.Domain.Formule;

public final class Réduction {

    static final Double REDUC_ETUDIANT = 0.2;
    static final Double REDUC_ANNEE = 0.3;

    private final Double taux;

    private Réduction(Double taux) {
        this.taux = taux;
    }

    public static Réduction auTaux(Double taux) {
        return new Réduction(taux);
    }

    static Réduction pourAbonnement(Adhérent adhérent, Formule formule) {
        Double tauxCalculé = 0.0;

        if (adhérent.estEtudiant()) {
            tauxCalculé += REDUC_ETUDIANT;
        }

        if (formule.estALannée()) {
            tauxCalculé += REDUC_ANNEE;
        }

        return new Réduction(tauxCalculé);
    }

    public Double taux() {
        return taux;
    }
}
