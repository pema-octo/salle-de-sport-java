package fr.octo.salle_de_sport.Adherents.Domain;

public interface Mailer {

    void sendEmail(String email, String message);
}
