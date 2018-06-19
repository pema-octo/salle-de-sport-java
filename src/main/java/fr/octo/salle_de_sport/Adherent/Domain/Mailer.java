package fr.octo.salle_de_sport.Adherent.Domain;

public interface Mailer {

    void sendEmail(String email, String message);
}
