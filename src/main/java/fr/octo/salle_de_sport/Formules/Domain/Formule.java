package fr.octo.salle_de_sport.Formules.Domain;

public final class Formule {

    private final FormuleId formuleId;
    private Prix prixDeBase;
    private final Integer duréeEnMois;

    public Formule(FormuleId formuleId, Double prixDeBase, DuréeFormule duréeEnMois) {
        this.formuleId = formuleId;
        this.prixDeBase = new Prix(prixDeBase);
        this.duréeEnMois = duréeEnMois.nbMois();
    }

    public static Formule nouvelleAuMois(FormuleId formuleId, Double prixDeBase) {
        return new Formule(formuleId, prixDeBase, DuréeFormule.MOIS);
    }

    public static Formule nouvelleALAnnée(FormuleId formuleId, Double prixDeBase) {
        return new Formule(formuleId, prixDeBase, DuréeFormule.ANNEE);
    }

    public FormuleId id() {
        return formuleId;
    }

    public Prix prixDeBase() {
        return prixDeBase;
    }

    public void changeDePrix(Prix nouveauPrix) {
        prixDeBase = nouveauPrix;
    }

    public Integer duréeEnMois() {
        return duréeEnMois;
    }

    public Boolean estALannée() {
        return DuréeFormule.ANNEE.nbMois() == duréeEnMois;
    }

    public String description() {
        return "Formule "+duréeEnMois+" mois à "+prixDeBase+" euros";
    }
}
