package fr.octo.craft.SalleDeSport.Formule.Domain;

public final class Formule {

    private final FormuleId id;
    private Prix prixDeBase;
    private final DuréeFormule durée;
    private final String nom;

    public Formule(FormuleId id, Double prixDeBase, DuréeFormule durée) {
        this.id = id;
        this.prixDeBase = new Prix(prixDeBase);
        this.durée = durée;
        this.nom = "Formule "+durée.nbMois()+" mois à "+prixDeBase+" euros";
    }

    public static Formule nouvelle(Double prixDeBase, DuréeFormule durée) {
        return new Formule(
            FormuleId.generate(),
            prixDeBase,
            durée
        );
    }

    public static Formule nouvelleAuMois(Double prixDeBase) {
        return Formule.nouvelle(prixDeBase, DuréeFormule.MOIS);
    }

    public static Formule nouvelleALAnnée(Double prixDeBase) {
        return Formule.nouvelle(prixDeBase, DuréeFormule.ANNEE);
    }

    public FormuleId id() {
        return id;
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
