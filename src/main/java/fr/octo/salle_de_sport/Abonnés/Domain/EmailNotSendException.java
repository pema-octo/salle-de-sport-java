package fr.octo.salle_de_sport.Abonnés.Domain;

public class EmailNotSendException extends Throwable {

    private EmailNotSendException(String message) {
        super(message);
    }

    public static EmailNotSendException introuvable(final String smtp) {
        return new EmailNotSendException("Serveur [" + smtp + "] introuvable.");
    }
}
