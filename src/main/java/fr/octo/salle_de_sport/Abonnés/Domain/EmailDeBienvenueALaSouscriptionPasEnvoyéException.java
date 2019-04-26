package fr.octo.salle_de_sport.Abonnés.Domain;

public class EmailDeBienvenueALaSouscriptionPasEnvoyéException extends Exception {
    private String message;

    public EmailDeBienvenueALaSouscriptionPasEnvoyéException(String message) {
        super(message);
    }
}
