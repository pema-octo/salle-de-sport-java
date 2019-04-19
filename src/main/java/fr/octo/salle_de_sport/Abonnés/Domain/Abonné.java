package fr.octo.salle_de_sport.Abonnés.Domain;

public final class Abonné {

    private final AbonnéId id;
    private final String email;
    private final String prénom;
    private Boolean estEtudiant;

    public Abonné(String email, String prénom) {
        this.id = new AbonnéId();
        this.email = email;
        this.prénom = prénom;
        this.estEtudiant = false;
    }

    public static Abonné étudiant(String email, String prénom) {
        var abonné = new Abonné(email, prénom);
        abonné.estEtudiant = true;

        return abonné;
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
