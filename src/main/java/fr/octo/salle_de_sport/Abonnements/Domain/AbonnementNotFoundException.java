package fr.octo.salle_de_sport.Abonnements.Domain;

public final class AbonnementNotFoundException extends Throwable {

    private AbonnementNotFoundException(String message) {
        super(message);
    }

    public static AbonnementNotFoundException introuvable(final AbonnementId abonnementId) {
        return new AbonnementNotFoundException("Abonnement [" + abonnementId + "] introuvable.");
    }
}
