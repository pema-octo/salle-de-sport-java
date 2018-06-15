package fr.octo.craft.SalleDeSport.Adherent.Domain;

public final class Adhérent {

    private final AdhérentId id;
    private final String email;
    private final String prénom;
    private final boolean estEtudiant;

    private Adhérent(AdhérentId id, String email, String prénom, boolean estEtudiant) {
        this.id = id;
        this.email = email;
        this.prénom = prénom;
        this.estEtudiant = estEtudiant;
    }

    public static Adhérent nouveau(AdhérentId adhérentId, String email, String prénom) {
        return new Adhérent(adhérentId, email, prénom, false);
    }

    public static Adhérent étudiant(AdhérentId adhérentId, String email, String prénom) {
        return new Adhérent(adhérentId, email, prénom, true);
    }

    public AdhérentId id() {
        return id;
    }

    public String email() {
        return email;
    }

    public String prénom() {
        return prénom;
    }

    public boolean estEtudiant() {
        return estEtudiant;
    }
}
