package fr.octo.salle_de_sport.Abonnés.Domain;

public final class Abonné {

    private final AbonnéId id;
    private final String email;
    private final String prénom;
    private final Boolean estEtudiant;

    private Abonné(AbonnéId abonnéId, String email, String prénom, Boolean estEtudiant) {
        this.id = abonnéId;
        this.email = email;
        this.prénom = prénom;
        this.estEtudiant = estEtudiant;
    }

    public static Abonné nouveau(AbonnéId abonnéId, String email, String prénom) {
        return new Abonné(abonnéId, email, prénom, false);
    }

    public static Abonné étudiant(AbonnéId abonnéId, String email, String prénom) {
        return new Abonné(abonnéId, email, prénom, true);
    }

    public AbonnéId id() {
        return id;
    }

    public String email() {
        return email;
    }

    public String prénom() {
        return prénom;
    }

    public Boolean estEtudiant() {
        return estEtudiant;
    }
}
