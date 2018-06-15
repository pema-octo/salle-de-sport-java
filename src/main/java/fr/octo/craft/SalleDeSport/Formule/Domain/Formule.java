package fr.octo.craft.SalleDeSport.Formule.Domain;

public final class Formule {

    private final FormuleId formuleId;
    private Prix prixDeBase;
    private final DuréeFormule durée;
    private final String nom;

    public Formule(FormuleId formuleId, Double prixDeBase, DuréeFormule durée) {
        this.formuleId = formuleId;
        this.prixDeBase = new Prix(prixDeBase);
        this.durée = durée;
        this.nom = "Formule "+durée.nbMois()+" mois à "+prixDeBase+" euros";
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

    public void changeDePrix(Double nouveauPrix) {
        prixDeBase = new Prix(nouveauPrix);
    }

    public DuréeFormule durée() {
        return durée;
    }

    public boolean estALannée() {
        return DuréeFormule.ANNEE.equals(durée);
    }

    public String nom() {
        return nom;
    }
}
