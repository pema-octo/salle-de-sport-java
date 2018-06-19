package fr.octo.salle_de_sport.Formule.Domain;

public enum DuréeFormule {
    MOIS(1),
    ANNEE(12);

    private final int nbMois;

    DuréeFormule(int nbMois) {
        this.nbMois = nbMois;
    }

    public int nbMois() {
        return nbMois;
    }
}
