package fr.octo.salle_de_sport.Formule.Domain;

public final class Formule {

    private final String formuleId;
    private Double prixDeBase;
    private final int duréeEnMois;

    public Formule(FormuleId formuleId, Double prixDeBase, DuréeFormule duréeEnMois) {
        this.formuleId = formuleId.toString();
        this.prixDeBase = new Prix(prixDeBase).montant();
        this.duréeEnMois = duréeEnMois.nbMois();
    }

    public static Formule nouvelleAuMois(FormuleId formuleId, Double prixDeBase) {
        return new Formule(formuleId, prixDeBase, DuréeFormule.MOIS);
    }

    public static Formule nouvelleALAnnée(FormuleId formuleId, Double prixDeBase) {
        return new Formule(formuleId, prixDeBase, DuréeFormule.ANNEE);
    }

    public FormuleId id() {
        return FormuleId.fromString(formuleId);
    }

    public Prix prixDeBase() {
        return new Prix(prixDeBase);
    }

    public void changeDePrix(Prix nouveauPrix) {
        prixDeBase = nouveauPrix.montant();
    }

    public int duréeEnMois() {
        return duréeEnMois;
    }

    public boolean estALannée() {
        return DuréeFormule.ANNEE.nbMois() == duréeEnMois;
    }

    public String description() {
        return "Formule "+duréeEnMois+" mois à "+prixDeBase+" euros";
    }
}
