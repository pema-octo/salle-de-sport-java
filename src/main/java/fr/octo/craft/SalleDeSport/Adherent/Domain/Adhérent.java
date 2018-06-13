package fr.octo.craft.SalleDeSport.Adherent.Domain;

public final class Adhérent {

    private final AdhérentId id;
    private final String email;
    private final String prénom;
    private final boolean estEtudiant;

    private Adhérent(AdhérentId id, String email, String prénom) {
        this.id = id;
        this.email = email;
        this.prénom = prénom;
        this.estEtudiant = false;
    }

    private Adhérent(String email, String prénom) {
        this(
            AdhérentId.generate(),
            email,
            prénom
        );
    }

    public static Adhérent nouveau(String email, String prénom) {
        return new Adhérent(email, prénom);
    }

    public static Adhérent nouveau(AdhérentId id, String email, String prénom) {
        return new Adhérent(id, email, prénom);
    }

    private Adhérent(AdhérentId id, String email, String prénom, boolean estEtudiant) {
        this.id = id;
        this.email = email;
        this.prénom = prénom;
        this.estEtudiant = estEtudiant;
    }

    private Adhérent(String email, String prénom, boolean estEtudiant) {
        this(
            AdhérentId.generate(),
            email,
            prénom,
            estEtudiant
        );
    }

    public static Adhérent étudiant(String email, String prénom) {
        return new Adhérent(email, prénom, true);
    }

    public static Adhérent étudiant(AdhérentId id, String email, String prénom) {
        return new Adhérent(id, email, prénom, true);
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
