package fr.octo.salle_de_sport.Adherents.Domain;

public final class Adhérent {

    private final String id;
    private final String email;
    private final String prénom;
    private final boolean estEtudiant;

    private Adhérent(AdhérentId adhérentId, String email, String prénom, boolean estEtudiant) {
        this.id = adhérentId.toString();
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
        return AdhérentId.fromString(id);
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
