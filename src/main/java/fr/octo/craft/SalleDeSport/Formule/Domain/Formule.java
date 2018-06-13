package fr.octo.craft.SalleDeSport.Formule.Domain;

public final class Formule {

    private final FormuleId id;
    private double prixDeBase;
    private final DuréeFormule durée;
    private final String nom;

    public Formule(FormuleId id, double prixDeBase, DuréeFormule durée) {
        this.id = id;
        this.prixDeBase = prixDeBase;
        this.durée = durée;
        this.nom = "Formule "+durée.getNbMois()+" mois à "+prixDeBase+" euros";
    }

    public static Formule nouvelle(double prixDeBase, DuréeFormule durée) {
        return new Formule(
            FormuleId.generate(),
            prixDeBase,
            durée
        );
    }

    public static Formule nouvelleAuMois(double prixDeBase) {
        return Formule.nouvelle(prixDeBase, DuréeFormule.MOIS);
    }

    public static Formule nouvelleALAnnée(double prixDeBase) {
        return Formule.nouvelle(prixDeBase, DuréeFormule.ANNEE);
    }

    public FormuleId id() {
        return id;
    }

    public double prixDeBase() {
        return prixDeBase;
    }

    public void changeDePrix(double nouveauPrix) {
        prixDeBase = nouveauPrix;
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
