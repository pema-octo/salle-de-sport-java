package fr.octo.craft.salle_de_sport.Abonnement.Domain;

public final class AbonnementRepositoryException extends Throwable {

    private AbonnementRepositoryException(String message) {
        super(message);
    }

    public static AbonnementRepositoryException introuvable(AbonnementId abonnementId) {
        return new AbonnementRepositoryException("Abonnement ["+abonnementId+"] introuvable.");
    }
}
