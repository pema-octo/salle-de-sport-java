package fr.octo.salle_de_sport.Adherent.Domain;

public final class AdhérentRepositoryException extends Throwable {

    private AdhérentRepositoryException(String message) {
        super(message);
    }

    public static AdhérentRepositoryException introuvable(AdhérentId adhérentId) {
        return new AdhérentRepositoryException("Adhérent ["+adhérentId+"] introuvable.");
    }
}
