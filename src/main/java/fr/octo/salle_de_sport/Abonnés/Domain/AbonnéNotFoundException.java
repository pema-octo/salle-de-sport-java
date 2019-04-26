package fr.octo.salle_de_sport.Abonnés.Domain;

public final class AbonnéNotFoundException extends Throwable {

    private AbonnéNotFoundException(String message) {
        super(message);
    }

    public static AbonnéNotFoundException introuvable(final AbonnéId abonnéId) {
        return new AbonnéNotFoundException("Abonné [" + abonnéId + "] introuvable.");
    }
}
